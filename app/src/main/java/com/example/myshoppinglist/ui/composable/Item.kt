package com.example.myshoppinglist.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R

internal const val ITEM_TAG = "Item"

@Composable
internal fun Item(
    item: ItemUiState,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .testTag(ITEM_TAG),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.subtitle2,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(
                    id = R.string.item_value_label,
                    item.value,
                ),
                style = MaterialTheme.typography.subtitle2,
            )
        }
        Text(text = item.description)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(
                    id = R.string.item_quantity_label,
                    item.quantity,
                ),
                style = MaterialTheme.typography.caption,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(
                    id = R.string.item_total_value_label,
                    item.totalValue,
                ),
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ItemPreview(
    @PreviewParameter(ShoppingListPreviewProviders::class)
    item: ItemUiState,
) {
    Item(item = item)
}
