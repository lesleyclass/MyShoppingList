package com.example.myshoppinglist.ui.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myshoppinglist.R
import com.example.myshoppinglist.fake.randomDouble
import com.example.myshoppinglist.fake.randomInt
import com.example.myshoppinglist.fake.randomMessage
import com.example.myshoppinglist.fake.randomName
import com.example.randomItemUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun item_shouldDisplayName(){
        val name = randomName()
        val item = randomItemUiState(name = name)

        composeTestRule.setContent {
            Item(item = item)
        }

        composeTestRule.onNodeWithText(name)
            .assertIsDisplayed()
    }

    @Test
    fun item_shouldDisplayValue(){
        val value = randomDouble()
        val item = randomItemUiState(value = value)

        composeTestRule.setContent {
            Item(item = item)
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedText = context.getString(R.string.item_value_label, value)
        composeTestRule.onNodeWithText(expectedText)
            .assertIsDisplayed()
    }

    @Test
    fun item_shouldDisplayQuantity(){
        val quantity = randomInt()
        val item = randomItemUiState(quantity = quantity)

        composeTestRule.setContent {
            Item(item = item)
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedText = context.getString(R.string.item_quantity_label, quantity)
        composeTestRule.onNodeWithText(expectedText)
            .assertIsDisplayed()
    }

    @Test
    fun item_shouldDisplayTotalValue(){
        val totalValue = randomDouble()
        val item = randomItemUiState(totalValue = totalValue)

        composeTestRule.setContent {
            Item(item = item)
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedText = context.getString(R.string.item_total_value_label, totalValue)
        composeTestRule.onNodeWithText(expectedText)
            .assertIsDisplayed()
    }

    @Test
    fun item_shouldDisplayDescription(){
        val description = randomMessage()
        val item = randomItemUiState(description = description)

        composeTestRule.setContent {
            Item(item = item)
        }

        composeTestRule.onNodeWithText(description)
            .assertIsDisplayed()
    }
}