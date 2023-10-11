package com.example.myshoppinglist.ui

import com.example.myshoppinglist.ItemUiState

internal sealed class ShoppingListUiEvent
internal object OnCreateNewItemClick : ShoppingListUiEvent()
internal data class OnFieldChange(val field: ItemField) : ShoppingListUiEvent()
internal data class OnSaveNewItemClick(val item: ItemUiState) : ShoppingListUiEvent()
