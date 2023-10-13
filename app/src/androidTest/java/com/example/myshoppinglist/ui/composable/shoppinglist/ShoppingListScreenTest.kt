package com.example.myshoppinglist.ui.composable.shoppinglist

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.text.AnnotatedString
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ui.composable.item.ITEM_LIST_TAG
import com.example.myshoppinglist.ui.composable.section.TOTAL_VALUE_SECTION_TAG
import com.example.myshoppinglist.ui.randomShoppingListUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ShoppingListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shoppingListScree_shouldDisplayToolbar() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            ShoppingListScreen(
                uiState = uiState,
                onCreateNewItemClick = {},
                onCloseClick = {},
            )
        }

        composeTestRule.onNodeWithTag(SHOPPING_LIST_SCREEN_TOOLBAR_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun shoppingListScreen_shouldDisplayTotalValueSection() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            ShoppingListScreen(
                uiState = uiState,
                onCreateNewItemClick = {},
                onCloseClick = {},
            )
        }

        composeTestRule.onNodeWithTag(TOTAL_VALUE_SECTION_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun shoppingListScreen_shouldDisplayItemList() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            ShoppingListScreen(
                uiState = uiState,
                onCreateNewItemClick = {},
                onCloseClick = {},
            )
        }

        composeTestRule.onNodeWithTag(ITEM_LIST_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun shoppingListScree_shouldDisplayNewItemButton() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            ShoppingListScreen(
                uiState = uiState,
                onCreateNewItemClick = {},
                onCloseClick = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val text =  context.getString(R.string.button_label)
        val buttonText = listOf(AnnotatedString(text))
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(SemanticsProperties.Text, buttonText)
                .and(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
        ).assertIsDisplayed()
    }
}