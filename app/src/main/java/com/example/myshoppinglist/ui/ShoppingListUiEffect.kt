package com.example.myshoppinglist.ui

import com.example.myshoppinglist.ItemUiState

internal sealed class ShoppingListUiEffect
internal data class CreateNewItem(val item: ItemUiState) : ShoppingListUiEffect()
