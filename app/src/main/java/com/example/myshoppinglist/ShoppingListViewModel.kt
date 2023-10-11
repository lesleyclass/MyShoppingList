package com.example.myshoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshoppinglist.di.ItemsStore
import com.example.myshoppinglist.ui.ItemField
import com.example.myshoppinglist.ui.NavigateToNewItem
import com.example.myshoppinglist.ui.NavigateToBackScreen
import com.example.myshoppinglist.ui.OnCreateNewItemClick
import com.example.myshoppinglist.ui.OnFieldChange
import com.example.myshoppinglist.ui.OnSaveNewItemClick
import com.example.myshoppinglist.ui.ShoppingListUiEffect
import com.example.myshoppinglist.ui.ShoppingListUiEvent
import com.example.myshoppinglist.ui.UiEffect
import com.example.myshoppinglist.ui.UiEffectImpl
import com.example.myshoppinglist.ui.UiEvent
import com.example.myshoppinglist.ui.UiEventImpl
import com.example.myshoppinglist.ui.UiState
import com.example.myshoppinglist.ui.UiStateImpl
import kotlinx.coroutines.launch

internal class ShoppingListViewModel(
    initialState: ShoppingListUiState,
    private val itemsStore: ItemsStore,
) : ViewModel(),
    UiState<ShoppingListUiState> by UiStateImpl(initialState),
    UiEvent<ShoppingListUiEvent> by UiEventImpl(),
    UiEffect<ShoppingListUiEffect> by UiEffectImpl() {

    init {
        viewModelScope.launch { handleEvents() }
        viewModelScope.launch { initialize() }
    }

    private suspend fun handleEvents() {
        eventFlow.collect {
            when(it){
                OnCreateNewItemClick -> onCreateNewItemClick()
                is OnSaveNewItemClick -> onSaveNewItemClick(it.item)
                is OnFieldChange -> onFieldChange(it.field)
            }
        }
    }

    private fun initialize() = setState {
        copy(items = itemsStore.getItems())
    }

    private suspend fun onCreateNewItemClick() {
        sendEffect(NavigateToNewItem)
    }

    private suspend fun onSaveNewItemClick(itemUiState: ItemUiState) {
        onUpdateItemList(itemUiState)
        sendEffect(NavigateToBackScreen(stateFlow.value))
    }

    private fun onUpdateItemList(itemUiState: ItemUiState) {
        itemsStore.insertValues(itemUiState)
        initialize()
    }

    private fun onFieldChange(field: ItemField) = setState {
        copy(
            newItem = when (field) {
                is ItemField.Name -> newItem.updateNameState(field)
                is ItemField.Value -> newItem.updateValueState(field)
                is ItemField.Quantity -> newItem.updateQuantityState(field)
                is ItemField.TotalValue -> newItem.updateTotalValueState(field)
                is ItemField.Description -> newItem.updateDescriptionState(field)
            }
        )
    }

    private fun ItemUiState.updateNameState(field: ItemField): ItemUiState =
        copy(name = field.value)

    private fun ItemUiState.updateValueState(field: ItemField): ItemUiState =
        copy(value = field.value.toDouble())

    private fun ItemUiState.updateQuantityState(field: ItemField): ItemUiState =
        copy(quantity = field.value.toInt())

    private fun ItemUiState.updateTotalValueState(field: ItemField): ItemUiState =
        copy(totalValue = field.value.toDouble())

    private fun ItemUiState.updateDescriptionState(field: ItemField): ItemUiState =
        copy(description = field.value)


    fun onSendEvent(event: ShoppingListUiEvent) {
        viewModelScope.launch { sendEvent(event) }
    }
}
