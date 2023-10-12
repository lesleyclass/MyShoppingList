package com.example.myshoppinglist.ui.composable.item

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ui.randomItemUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ItemFormTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun itemForm_shouldDisplayInputNameTextForm(){
        val item = randomItemUiState()

        composeTestRule.setContent {
            ItemForm(
                uiState = item,
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_name_form)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }

    @Test
    fun itemForm_shouldDisplayInputValueTextForm(){
        val item = randomItemUiState()

        composeTestRule.setContent {
            ItemForm(
                uiState = item,
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_value_form)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }

    @Test
    fun itemForm_shouldDisplayInputQuantityTextForm(){
        val item = randomItemUiState()

        composeTestRule.setContent {
            ItemForm(
                uiState = item,
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_quantity_form)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }

    @Test
    fun itemForm_shouldDisplayInputTotalValueTextForm(){
        val item = randomItemUiState()

        composeTestRule.setContent {
            ItemForm(
                uiState = item,
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_total_value_form)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }

    @Test
    fun itemForm_shouldDisplayInputDescriptionTextForm(){
        val item = randomItemUiState()

        composeTestRule.setContent {
            ItemForm(
                uiState = item,
                onFieldChange = {},
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_description_form)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }
}
