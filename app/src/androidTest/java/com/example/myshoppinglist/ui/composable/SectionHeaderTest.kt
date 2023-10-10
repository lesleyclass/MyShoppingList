package com.example.myshoppinglist.ui.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myshoppinglist.fake.randomMessage
import com.example.myshoppinglist.fake.randomTitle
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class SectionHeaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sectionHeader_shouldDisplayTitle() {
        val title = randomTitle()

        composeTestRule.setContent {
            SectionHeader(
                title = title,
            )
        }

        composeTestRule.onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun sectionHeader_withSubtitle_shouldDisplaySubtitle() {
        val subTitle = randomMessage()

        composeTestRule.setContent {
            SectionHeader(
                title = randomTitle(),
                subtitle = subTitle,
            )
        }

        composeTestRule.onNodeWithText(subTitle)
            .assertIsDisplayed()
    }

    @Test
    fun sectionHeader_withoutSubtitle_shouldNotDisplaySubtitle() {
        composeTestRule.setContent {
            SectionHeader(
                title = randomTitle(),
                subtitle = null,
            )
        }

        composeTestRule.onNodeWithTag(SECTION_HEADER_SUBTITLE_TAG)
            .assertDoesNotExist()
    }
}