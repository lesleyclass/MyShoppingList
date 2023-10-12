package com.example.myshoppinglist.ui.composable.section

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myshoppinglist.R
import com.example.myshoppinglist.fake.randomDouble
import com.example.myshoppinglist.fake.randomTitle
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class TotalValueSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sectionHeader_shouldDisplayLabel() {
        val label = randomTitle()

        composeTestRule.setContent {
            TotalValueSection(
                label = label,
                value = randomDouble(),
            )
        }

        composeTestRule.onNodeWithText(label)
            .assertIsDisplayed()
    }

    @Test
    fun sectionHeader_shouldDisplayValue() {
        val value = randomDouble()

        composeTestRule.setContent {
            TotalValueSection(
                label = randomTitle(),
                value = value,
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedWarningMessage = context.getString(R.string.item_value_label, value)
        composeTestRule.onNodeWithText(expectedWarningMessage)
            .assertDoesNotExist()
    }


}