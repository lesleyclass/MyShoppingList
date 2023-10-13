package com.example.myshoppinglist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.composable.item.NewItemScreen
import com.example.myshoppinglist.ui.composable.shoppinglist.ShoppingListScreen
import com.example.myshoppinglist.ui.navigation.destination.Main
import com.example.myshoppinglist.ui.navigation.destination.NewProduct
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

internal const val ITEMS_ARG: String = "uiState"

@Composable
internal fun MyShoppingListContainer(
    onCloseClick: () -> Unit,
    navController: NavHostController = rememberNavController(),
){
    NavHost(navController = navController, startDestination = Main.route) {
        composable(
            route = Main.route
        ) { backStackEntry ->
            val state = createShoppingListUiState(backStackEntry)
            val navigator = ShoppingListNavigator(navController)
            val viewModel = getViewModel<ShoppingListViewModel> { parametersOf(state) }

            ShoppingListScreen(
                viewModel = viewModel,
                uiState = state,
                navigator = navigator,
                onCloseClick = onCloseClick,
            )

        }
        composable(
            route = NewProduct.route,
        ) { backStackEntry ->
            val state = createShoppingListUiState(backStackEntry)
            val navigator = ShoppingListNavigator(navController)
            val viewModel = getViewModel<ShoppingListViewModel> { parametersOf(state) }

            NewItemScreen(
                viewModel = viewModel,
                navigator = navigator,
            )
        }
    }
}

private fun createShoppingListUiState(
    backStackEntry: NavBackStackEntry,
) : ShoppingListUiState =
    if (backStackEntry.containsInstallmentArg()) {
         backStackEntry.extractInstallmentArg() ?: ShoppingListUiState()
    } else {
        ShoppingListUiState() }


private fun NavBackStackEntry.containsInstallmentArg(): Boolean =
    savedStateHandle.contains(ITEMS_ARG)

private fun NavBackStackEntry.extractInstallmentArg(): ShoppingListUiState? =
    savedStateHandle.get<ShoppingListUiState>(ITEMS_ARG)
