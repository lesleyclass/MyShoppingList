package com.example.myshoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshoppinglist.ui.NavigateToNewItem
import com.example.myshoppinglist.ui.OnCreateNewItemClick
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
) : ViewModel(),
    UiState<ShoppingListUiState> by UiStateImpl(initialState),
    UiEvent<ShoppingListUiEvent> by UiEventImpl(),
    UiEffect<ShoppingListUiEffect> by UiEffectImpl() {

    init {
        viewModelScope.launch { handleEvents() }
    }

    private suspend fun handleEvents() {
        eventFlow.collect() {
            when(it){
                OnCreateNewItemClick -> onCreateNewItemClick()
            }
        }
    }

    private suspend fun onCreateNewItemClick() {
        sendEffect(NavigateToNewItem(stateFlow.value.newItem))
    }

    fun onSendEvent(event: ShoppingListUiEvent) {
        viewModelScope.launch { sendEvent(event) }
    }
}
