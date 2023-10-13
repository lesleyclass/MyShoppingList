package com.example.myshoppinglist.ui.composable.item

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
import com.example.myshoppinglist.ui.composable.section.SECTION_HEADER_TAG
import com.example.myshoppinglist.ui.randomShoppingListUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class NewItemScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun newItemScreen_shouldDisplaySectionHeader() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            NewItemScreen(
                uiState = uiState,
                onSaveButtonClick = {},
                onCancelButtonClick = {},
                onFieldChange = {},
            )
        }

        composeTestRule.onNodeWithTag(SECTION_HEADER_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun newItemScreen_shouldDisplayItemForm() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            NewItemScreen(
                uiState = uiState,
                onSaveButtonClick = {},
                onCancelButtonClick = {},
                onFieldChange = {},
            )
        }

        composeTestRule.onNodeWithTag(ITEM_FORM_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun newItemScreen_shouldDisplayCancelButton() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            NewItemScreen(
                uiState = uiState,
                onSaveButtonClick = {},
                onCancelButtonClick = {},
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val text =  context.getString(R.string.cancel_button_label).uppercase()
        val buttonText = listOf(AnnotatedString(text))
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(SemanticsProperties.Text, buttonText)
                .and(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
        ).assertIsDisplayed()
    }

    @Test
    fun newItemScreen_shouldDisplaySaveButton() {
        val uiState = randomShoppingListUiState()

        composeTestRule.setContent {
            NewItemScreen(
                uiState = uiState,
                onSaveButtonClick = {},
                onCancelButtonClick = {},
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val text =  context.getString(R.string.save_button_label).uppercase()
        val buttonText = listOf(AnnotatedString(text))
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(SemanticsProperties.Text, buttonText)
                .and(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
        ).assertIsDisplayed()
    }
}