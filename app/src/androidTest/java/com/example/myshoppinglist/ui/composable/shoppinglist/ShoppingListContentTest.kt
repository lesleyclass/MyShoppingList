package com.example.myshoppinglist.ui.composable.shoppinglist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myshoppinglist.ui.composable.item.ITEM_LIST_ITEM_TAG
import com.example.myshoppinglist.ui.randomShoppingListUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ShoppingListContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shoppingListContent_shouldDisplayItemList() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            ShoppingListContent(
                uiState = uiState,
            )
        }

        composeTestRule.onNodeWithTag(ITEM_LIST_ITEM_TAG)
            .assertIsDisplayed()
    }
}