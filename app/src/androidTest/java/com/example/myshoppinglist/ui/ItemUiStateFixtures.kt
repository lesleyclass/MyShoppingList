package com.example.myshoppinglist.ui

import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.fake.randomDouble
import com.example.myshoppinglist.fake.randomInt
import com.example.myshoppinglist.fake.randomMessage
import com.example.myshoppinglist.fake.randomName

internal fun randomItemUiState(
    name: String = randomName(),
    value: Double = randomDouble(),
    quantity: Int = randomInt(),
    totalValue: Double = randomDouble(),
    description: String = randomMessage(),
): ItemUiState =
    ItemUiState(
        name = name,
        value = value,
        quantity = quantity,
        totalValue = totalValue,
        description = description,
    )

internal fun randomItemUiStateList(
    size: Int = randomInt(min = 1),
): List<ItemUiState> =
    mutableListOf<ItemUiState>().apply {
        repeat(size) {
            add(randomItemUiState())
        }
    }
