package com.example.myshoppinglist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
internal data class ItemUiState (
    val name: String = "",
    val value: Double = 0.0,
    val quantity: Int = 0,
    val totalValue: Double = 0.0,
    val description: String = "",
) : Parcelable
