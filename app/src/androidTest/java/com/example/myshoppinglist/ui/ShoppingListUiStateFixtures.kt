package com.example.myshoppinglist.ui

import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.ShoppingListUiState

internal fun randomShoppingListUiState(
    items: List<ItemUiState> = randomItemUiStateList(),
    newItem: ItemUiState = randomItemUiState(),
): ShoppingListUiState =
    ShoppingListUiState(
        items = items,
        newItem = newItem,
    )

