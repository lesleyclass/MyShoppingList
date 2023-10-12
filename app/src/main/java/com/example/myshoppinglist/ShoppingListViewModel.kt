package com.example.myshoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshoppinglist.ui.store.ItemsStore
import com.example.myshoppinglist.domain.ItemField
import com.example.myshoppinglist.ui.composable.shoppinglist.NavigateToNewItem
import com.example.myshoppinglist.ui.composable.shoppinglist.NavigateToBackScreen
import com.example.myshoppinglist.ui.composable.shoppinglist.OnCreateNewItemClick
import com.example.myshoppinglist.ui.composable.shoppinglist.OnFieldChange
import com.example.myshoppinglist.ui.composable.shoppinglist.OnSaveNewItemClick
import com.example.myshoppinglist.ui.composable.shoppinglist.ShoppingListUiEffect
import com.example.myshoppinglist.ui.composable.shoppinglist.ShoppingListUiEvent
import com.example.myshoppinglist.arch.UiEffect
import com.example.myshoppinglist.arch.UiEffectImpl
import com.example.myshoppinglist.arch.UiEvent
import com.example.myshoppinglist.arch.UiEventImpl
import com.example.myshoppinglist.ui.UiState
import com.example.myshoppinglist.ui.UiStateImpl
import com.example.myshoppinglist.validation.ButtonValidation
import kotlinx.coroutines.launch

internal class ShoppingListViewModel(
    initialState: ShoppingListUiState,
    private val itemsStore: ItemsStore,
    private val saveButtonValidation: ButtonValidation,
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
            .updateTotalAmount()
            .updateSaveButton()
    }

    private fun ShoppingListUiState.updateTotalAmount() : ShoppingListUiState =
        copy(totalValue = itemsStore.getTotalValue())

    private suspend fun onCreateNewItemClick() {
        sendEffect(NavigateToNewItem)
    }

    private suspend fun onSaveNewItemClick(itemUiState: ItemUiState) {
        onUpdateItemList(itemUiState)
        sendEffect(NavigateToBackScreen(stateFlow.value))
    }

    private fun onUpdateItemList(itemUiState: ItemUiState) {
        itemsStore.insertItem(itemUiState)
        initialize()
    }

    private fun onFieldChange(field: ItemField){
         when (field) {
                is ItemField.Name -> updateNameState(field)
                is ItemField.Value -> updateValueState(field)
                is ItemField.Quantity -> updateQuantityState(field)
                is ItemField.TotalValue -> updateTotalValueState(field)
                is ItemField.Description -> updateDescriptionState(field)
         }
    }

    private fun updateNameState(field: ItemField) = setState {
        copy(newItem = newItem.copy( name = field.value)).updateSaveButton()
    }

    private fun updateValueState(field: ItemField) = setState {
        copy(newItem = newItem.copy( value = field.value?.toDoubleOrNull())).updateSaveButton()
    }

    private fun updateQuantityState(field: ItemField) = setState {
        copy(newItem = newItem.copy( quantity = field.value?.toIntOrNull())).updateSaveButton()
    }

    private fun updateTotalValueState(field: ItemField) = setState {
        copy(newItem = newItem.copy( totalValue = field.value?.toDoubleOrNull())).updateSaveButton()
    }

    private fun updateDescriptionState(field: ItemField) = setState {
        copy(
            newItem = newItem.copy( description = field.value),
            isSaveButtonEnabled = saveButtonValidation.isValid(this.newItem)
        )
    }

    private fun ShoppingListUiState.updateSaveButton() : ShoppingListUiState =
        copy(isSaveButtonEnabled = saveButtonValidation.isValid(this.newItem))

    fun onSendEvent(event: ShoppingListUiEvent) {
        viewModelScope.launch { sendEvent(event) }
    }
}
