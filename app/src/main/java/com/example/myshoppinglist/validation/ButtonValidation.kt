package com.example.myshoppinglist.validation

import com.example.myshoppinglist.ItemUiState

internal interface ButtonValidation {
    fun isValid(itemUiState: ItemUiState): Boolean
}
