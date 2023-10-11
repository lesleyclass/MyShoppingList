package com.example.myshoppinglist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
internal data class ShoppingListUiState (
    val items: List<ItemUiState> = emptyList(),
    val newItem: ItemUiState = ItemUiState(),
    val totalValue: Double = 0.0,
) : Parcelable
