package com.example

import com.example.myshoppinglist.fake.randomDouble
import com.example.myshoppinglist.fake.randomInt
import com.example.myshoppinglist.fake.randomMessage
import com.example.myshoppinglist.fake.randomName
import com.example.myshoppinglist.ItemUiState

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
