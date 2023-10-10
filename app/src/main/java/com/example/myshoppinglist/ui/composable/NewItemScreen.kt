package com.example.myshoppinglist.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.navigation.ShoppingListNavigator


@Composable
internal fun NewItemScreen(
    viewModel: ShoppingListViewModel,
    navigator: ShoppingListNavigator,
){
    val uiState by viewModel.stateFlow.collectAsState()

    NewItemScreen(
        uiState = uiState.newItem,
        onSaveButtonClick = {},
        onCancelButtonClick = { navigator.navigateToBackScreen() },
        onFieldChange = {},
    )
}

@Composable
internal fun  NewItemScreen(
    uiState: ItemUiState,
    onSaveButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    onFieldChange: (ItemField) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionHeader(
            title = stringResource(R.string.new_item_screem_title),
            subtitle = stringResource(R.string.new_item_screen_subtitle),
        )
        ItemForm(
            uiState = uiState,
            onFieldChange = onFieldChange,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier.fillMaxWidth().testTag(""),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally,),
        ) {
            Button(
                onClick = { onCancelButtonClick() },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.weight(0.5f).fillMaxWidth().height(50.dp)
            ) {
                Text(text = stringResource(R.string.cancel_button_label).uppercase())
            }
            Button(
                onClick = { onSaveButtonClick() },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.weight(0.5f).fillMaxWidth().height(50.dp)
            ) {
                Text(text = stringResource(R.string.save_button_label).uppercase())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun NewItemScreenPreview() {
    NewItemScreen(
        uiState = ItemUiState(),
        onSaveButtonClick = {},
        onCancelButtonClick = {},
        onFieldChange = {},
    )
}