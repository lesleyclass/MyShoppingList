package com.example.myshoppinglist.validation

import com.example.myshoppinglist.ItemUiState

internal class SaveButtonValidation : ButtonValidation {
    override fun isValid(itemUiState: ItemUiState): Boolean {
        return itemUiState.run {
            nameValidation() &&
                    valueValidation() &&
                    quantityValidation() &&
                    totalValueValidation() &&
                    descriptionValidation()
        }
    }

    private fun ItemUiState.nameValidation(): Boolean = name != null
    private fun ItemUiState.valueValidation(): Boolean = value != null
    private fun ItemUiState.quantityValidation(): Boolean = quantity != null
    private fun ItemUiState.totalValueValidation(): Boolean = totalValue != null
    private fun ItemUiState.descriptionValidation(): Boolean = description != null
}
