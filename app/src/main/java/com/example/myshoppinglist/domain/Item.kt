package com.example.myshoppinglist.domain

internal data class Item(
    val name: String,
    val value: Double,
    val quantity: Int,
    val totalValue: Double,
    val description: String,
)
