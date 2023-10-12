package com.example.myshoppinglist.ui.store

import com.example.myshoppinglist.ItemUiState
import com.google.common.truth.Truth.assertThat
import org.junit.Test

@Suppress("UnnecessaryVariable")
internal class ItemStoreTest {

    @Test
    fun getItems_whenInsertItemIsCalled_shouldReturnItems() {
        val itemsStore = ItemsStore()
        val item = ItemUiState()
        itemsStore.insertItem(item = item)

        val actual = itemsStore.getItems()

        val expected = listOf(item)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun getItems_whenInsertItemIsNotCalled_shouldReturnEmptyList() {
        val itemsStore = ItemsStore()

        val actual = itemsStore.getItems()

        val expected = emptyList<ItemUiState>()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun getTotalValue_whenInsertItemIsCalled_shouldReturnTotalValue() {
        val itemsStore = ItemsStore()
        val item1 = ItemUiState()
        val item2 = ItemUiState()
        val item3 = ItemUiState()
        itemsStore.insertItem(item = item1)
        itemsStore.insertItem(item = item2)
        itemsStore.insertItem(item = item3)

        val actual = itemsStore.getTotalValue()

        val items = listOf(item1, item2, item3)
        val expected = items.sumOf { it.totalValue ?: 0.0 }
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun getTotalValue_whenInsertItemIsNotCalled_shouldReturnZero() {
        val itemsStore = ItemsStore()

        val actual = itemsStore.getTotalValue()

        val expected = 0.0
        assertThat(actual).isEqualTo(expected)
    }
}