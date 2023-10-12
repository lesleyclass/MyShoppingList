package com.example.myshoppinglist.ui.composable.shoppinglist

import com.example.myshoppinglist.ShoppingListUiState

internal sealed class ShoppingListUiEffect
internal data class NavigateToBackScreen(val shoppingListUiState: ShoppingListUiState) : ShoppingListUiEffect()
internal object NavigateToNewItem : ShoppingListUiEffect()
