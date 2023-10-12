package com.example.myshoppinglist

import com.example.myshoppinglist.fake.randomBoolean
import com.example.myshoppinglist.fake.randomDouble

@Suppress("LongParameterList", "MaxLineLength")
internal fun randomShoppingListUiState(
    items: List<ItemUiState> = randomItemUiStateList(),
    newItem: ItemUiState = randomItemUiState(),
    totalValue: Double = randomDouble(),
    isSaveButtonEnabled: Boolean = randomBoolean(),
): ShoppingListUiState =
    ShoppingListUiState(
        items = items,
        newItem = newItem,
        totalValue = totalValue,
        isSaveButtonEnabled = isSaveButtonEnabled,
    )
