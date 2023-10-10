package com.example.myshoppinglist.ui.composable

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.myshoppinglist.ItemUiState

internal class ShoppingListPreviewProviders :
    PreviewParameterProvider<ItemUiState> {
    override val values: Sequence<ItemUiState> =
        sequenceOf(
            ItemUiState(
                name = "Arroz",
                value = 3.20,
                quantity = 1,
                totalValue = 3.20,
                description = "Branco tipo 1",
            )
        )
}
