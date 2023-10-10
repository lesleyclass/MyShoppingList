package com.example.myshoppinglist.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.ShoppingListUiState

@Composable
internal fun ShoppingListContent(
    uiState: ShoppingListUiState,
) {
    ItemList(items = uiState.items)
}

@Preview(showBackground = true)
@Composable
internal fun ShoppingListContentPreview(){
    val uiState = ShoppingListUiState(items = emptyList())
    ShoppingListContent(uiState = uiState)
}
