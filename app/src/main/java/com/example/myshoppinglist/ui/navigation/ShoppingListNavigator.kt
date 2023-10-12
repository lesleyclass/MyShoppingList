package com.example.myshoppinglist.ui.navigation

import androidx.navigation.NavController
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ui.navigation.destination.NewProduct

internal data class ShoppingListNavigator(
    private val navController: NavController,
) {
    fun navigateToNewItem() {
        navController.navigate(NewProduct.route)
    }

    fun navigateToBackScreen(uiState: ShoppingListUiState){
        navController.previousBackStackEntry?.savedStateHandle?.set(ITEMS_ARG, uiState)
        navController.popBackStack()
    }
}
