package com.example.myshoppinglist.arch

import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.domain.ItemField

internal sealed class ShoppingListUiEvent
internal object OnCreateNewItemClick : ShoppingListUiEvent()
internal data class OnFieldChange(val field: ItemField) : ShoppingListUiEvent()
internal data class OnSaveNewItemClick(val item: ItemUiState) : ShoppingListUiEvent()
