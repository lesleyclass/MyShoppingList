package com.example.myshoppinglist.ui.composable.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R

internal const val ITEM_LIST_TAG = "ItemList"
internal const val ITEM_LIST_ITEM_TAG = "ItemListItem"
internal const val ITEM_LIST_DIVIDER_TAG = "ItemListDivider"

@Composable
internal fun ItemList(
    items: List<ItemUiState>,
) {
    LazyColumn(modifier = Modifier.testTag(ITEM_LIST_TAG)){
        itemsIndexed(items) { index, item ->
            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .testTag(ITEM_LIST_ITEM_TAG),
            ) {
                Item(item)
            }
            if (index < items.lastIndex) {
                Divider(
                    thickness = dimensionResource(id = R.dimen.spacing_micro),
                    modifier = Modifier.testTag(ITEM_LIST_DIVIDER_TAG))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ItemListPreview(
    @PreviewParameter(ItemListPreviewProviders::class)
    items: List<ItemUiState>,
) {
    ItemList(items = items)
}
