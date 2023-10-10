package com.example.myshoppinglist.ui.composable

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myshoppinglist.fake.randomInt
import com.example.myshoppinglist.ui.randomItemUiStateList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("UnnecessaryVariable")
@RunWith(AndroidJUnit4::class)
internal class ItemListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun itemList_withItems_shouldDisplayItems() {
        val itemCount = randomInt(min = 1, max = 3)
        val items = randomItemUiStateList(size = itemCount)

        composeTestRule.setContent {
            ItemList(items = items)
        }

        val expectedItemCount = itemCount
        composeTestRule.onAllNodesWithTag(testTag = ITEM_LIST_ITEM_TAG)
            .assertCountEquals(expectedItemCount)
    }

    @Test
    fun itemList_withItems_shouldDisplayDividersBetweenThem() {
        val itemCount = randomInt(min = 1, max = 5)
        val items = randomItemUiStateList(size = itemCount)

        composeTestRule.setContent {
            ItemList(items = items)
        }

        val expectedDividersCount = itemCount - 1
        composeTestRule.onAllNodesWithTag(testTag = ITEM_LIST_DIVIDER_TAG)
            .assertCountEquals(expectedDividersCount)
    }
}
