package com.example.myshoppinglist.ui.composable.toolbar

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
import com.example.myshoppinglist.ui.composable.Item
import com.example.randomItemUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun topAppBar_shouldDisplayScreenTitle() {
        val titleRes = R.string.toolbar_title

        composeTestRule.setContent {
            TopAppBar(
                titleRes = titleRes,
                navigationIconRes = R.drawable.ic_baseline_close,
                onNavigationIconClick = {},
                tag = "",
            )
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedTitle = context.getString(titleRes)
        composeTestRule.onNodeWithText(expectedTitle)
            .assertIsDisplayed()
    }
}