package com.example.myshoppinglist.di

import com.example.myshoppinglist.ItemUiState

internal class ItemsStore {
    private var items: List<ItemUiState> = emptyList()

    internal fun insertValues(item: ItemUiState) {
        items = this.items.plus(item)
    }

    internal fun getItems(): List<ItemUiState> = this.items
    internal fun getTotalValue(): Double = this.items.sumOf { it.totalValue }

}
