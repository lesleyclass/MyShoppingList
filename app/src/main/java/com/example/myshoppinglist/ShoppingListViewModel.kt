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
        itemsStore.insertValues(itemUiState)
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
        copy(newItem = newItem.copy( value = field.value?.toDouble())).updateSaveButton()
    }

    private fun updateQuantityState(field: ItemField) = setState {
        copy(newItem = newItem.copy( quantity = field.value?.toInt())).updateSaveButton()
    }

    private fun updateTotalValueState(field: ItemField) = setState {
        copy(newItem = newItem.copy( totalValue = field.value?.toDouble())).updateSaveButton()
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
