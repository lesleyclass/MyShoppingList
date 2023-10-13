package com.example.myshoppinglist.ui.composable.item

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ui.composable.shoppinglist.ShoppingListPreviewProviders

internal const val ITEM_TAG = "Item"
internal const val FULL_WEIGHT = 1f

@Composable
internal fun Item(
    item: ItemUiState,
) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.spacing_tiny),
                vertical = dimensionResource(id = R.dimen.spacing_micro),
            )
            .testTag(ITEM_TAG),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_nano)),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            item.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body1,
                )
            }
            item.value?.let {
                Spacer(modifier = Modifier.weight(FULL_WEIGHT))
                Text(
                    text = stringResource(
                        id = R.string.item_value_label,
                        it,
                    ),
                    style = MaterialTheme.typography.body1,
                )
            }
        }
        item.description?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.body2,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_tiny), )
        ) {
            item.quantity?.let {
                Text(
                    text = stringResource(
                        id = R.string.item_quantity_label,
                        it,
                    ),
                    style = MaterialTheme.typography.body2,
                )
            }
            item.totalValue?.let {
                Spacer(modifier = Modifier.weight(FULL_WEIGHT))
                Text(
                    text = stringResource(
                        id = R.string.item_total_value_label,
                        it,
                    ),
                    style = MaterialTheme.typography.body2,
                )
            }
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
