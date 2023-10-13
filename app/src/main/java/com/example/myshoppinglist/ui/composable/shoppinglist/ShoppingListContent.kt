package com.example.myshoppinglist.ui.composable.shoppinglist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ui.composable.item.ItemList

@Composable
internal fun ShoppingListContent(
    uiState: ShoppingListUiState,
) {
    ItemList(items = uiState.items)
}

@Preview(showBackground = true)
@Composable
internal fun ShoppingListContentPreview(){
    val uiState = ShoppingListUiState(items = emptyList(), ItemUiState())
    ShoppingListContent(uiState = uiState)
}
