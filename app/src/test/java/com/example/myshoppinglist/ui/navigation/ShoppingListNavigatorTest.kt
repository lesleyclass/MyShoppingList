package com.example.myshoppinglist.ui.navigation

import androidx.navigation.NavHostController
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ui.navigation.destination.NewProduct
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class ShoppingListNavigatorTest {

    @Test
    fun navigateToNewItem_shouldNavigateToNewItemRoute() {
        val navController = mockk<NavHostController>()
        every { navController.navigate(route = any()) } returns Unit
        val navigator = ShoppingListNavigator(navController)

        navigator.navigateToNewItem()

        val route = NewProduct.route
        verify(exactly = 1) {
            navController.navigate(route)
        }
    }

    @Test
    fun navigateToBackScreen_shouldNavigateToBackScreen() {
        val uiState = ShoppingListUiState()
        val navController = mockk<NavHostController>()
        val navigator = ShoppingListNavigator(navController)

        navigator.navigateToBackScreen(uiState)

        verify(exactly = 1) {
            navController.popBackStack()
        }
    }
}