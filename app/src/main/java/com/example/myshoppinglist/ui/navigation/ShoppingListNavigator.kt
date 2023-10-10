package com.example.myshoppinglist.ui.navigation

import androidx.navigation.NavController
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.ui.navigation.destination.NewProduct

internal data class ShoppingListNavigator(
    private val navController: NavController,
) {
    fun navigateToNewItem(itemUiState: ItemUiState) {
        navController.navigate(NewProduct.createRoute(itemUiState))
    }

    fun navigateToBackScreen() = navController.popBackStack()
}
