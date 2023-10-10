package com.example.myshoppinglist.ui.composable

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.myshoppinglist.ItemUiState

internal class ItemListPreviewProviders :
    PreviewParameterProvider<List<ItemUiState>> {
    override val values: Sequence<List<ItemUiState>> =
        sequenceOf(
            listOf(
                ItemUiState(
                    name = "Arroz",
                    value = 3.20,
                    quantity = 1,
                    totalValue = 3.20,
                    description = "Branco tipo 1",
                ),
                ItemUiState(
                    name = "Feijão",
                    value = 7.89,
                    quantity = 1,
                    totalValue = 7.89,
                    description = "Feijão preto",
                ),
                ItemUiState(
                    name = "Ketchup",
                    value = 11.99,
                    quantity = 1,
                    totalValue = 11.99,
                    description = "Tradicional Heinz",
                )
            )
        )
}
