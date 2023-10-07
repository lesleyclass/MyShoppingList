package com.example.myshoppinglist.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.composable.ShoppingListScreen
import com.example.myshoppinglist.ui.navigation.Main
import com.example.myshoppinglist.ui.navigation.ShoppingListNavigator
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun MyShoppingListContainer(
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
            )

        }
    }
}

private fun createShoppingListUiState(): ShoppingListUiState =
    ShoppingListUiState(
        items = emptyList(),
    )
