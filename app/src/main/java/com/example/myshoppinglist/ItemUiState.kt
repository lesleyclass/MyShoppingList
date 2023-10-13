package com.example.myshoppinglist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
internal data class ItemUiState (
    val name: String? = null,
    val value: Double? = null,
    val quantity: Int? = null,
    val totalValue: Double? = null,
    val description: String? = null,
) : Parcelable
