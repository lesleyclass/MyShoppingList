package com.example.myshoppinglist.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.composable.NewItemScreen
import com.example.myshoppinglist.ui.composable.ShoppingListScreen
import com.example.myshoppinglist.ui.navigation.destination.Main
import com.example.myshoppinglist.ui.navigation.destination.NewProduct
import com.example.myshoppinglist.ui.navigation.ShoppingListNavigator
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun MyShoppingListContainer(
    onCloseClick: () -> Unit,
    navController: NavHostController = rememberNavController(),
){
    NavHost(navController = navController, startDestination = Main.route) {
        composable(route = Main.route) {
            val state = createShoppingListUiState()
            val navigator = ShoppingListNavigator(navController)
            val viewModel = getViewModel<ShoppingListViewModel> { parametersOf(state, navigator) }

            ShoppingListScreen(
                viewModel = viewModel,
                navigator = navigator,
                onCloseClick = onCloseClick,
            )

        }
        composable(route = NewProduct.route) {
            val state = createShoppingListUiState()
            val navigator = ShoppingListNavigator(navController)
            val viewModel = getViewModel<ShoppingListViewModel> { parametersOf(state, navigator) }

            NewItemScreen(
                viewModel = viewModel,
                navigator = navigator,
            )

        }
    }
}

private fun createShoppingListUiState(): ShoppingListUiState =
    ShoppingListUiState(
        items = listOf(
            ItemUiState(
                name = "Arroz",
                value = 3.20,
                quantity = 1,
                totalValue = 3.20,
                description = "Branco tipo 1",
            ),
        ),
        newItem = ItemUiState(),
    )
