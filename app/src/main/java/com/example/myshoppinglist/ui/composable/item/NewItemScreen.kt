package com.example.myshoppinglist.ui.composable.item


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.domain.ItemField
import com.example.myshoppinglist.ui.composable.section.SectionHeader
import com.example.myshoppinglist.ui.composable.shoppinglist.NavigateToBackScreen
import com.example.myshoppinglist.ui.composable.shoppinglist.NavigateToNewItem
import com.example.myshoppinglist.ui.composable.shoppinglist.OnFieldChange
import com.example.myshoppinglist.ui.composable.shoppinglist.OnSaveNewItemClick
import com.example.myshoppinglist.ui.navigation.ShoppingListNavigator

internal const val HALF_WEIGHT = 0.5f

@Composable
internal fun NewItemScreen(
    viewModel: ShoppingListViewModel,
    navigator: ShoppingListNavigator,
){
    val uiState by viewModel.stateFlow.collectAsState()

    NewItemScreen(
        uiState = uiState,
        onSaveButtonClick = { item -> viewModel.onSendEvent(OnSaveNewItemClick(item))},
        onCancelButtonClick = { shoppingListUiState ->  navigator.navigateToBackScreen(shoppingListUiState) },
        onFieldChange = { viewModel.onSendEvent(OnFieldChange(it)) },
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.effectFlow.collect{ effect ->
            when (effect) {
                is NavigateToNewItem -> {}
                is NavigateToBackScreen -> { navigator.navigateToBackScreen(effect.shoppingListUiState) }
            }
        }
    }
}

@Composable
internal fun  NewItemScreen(
    uiState: ShoppingListUiState,
    onSaveButtonClick: (ItemUiState) -> Unit,
    onCancelButtonClick: (ShoppingListUiState) -> Unit,
    onFieldChange: (ItemField) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionHeader(
            title = stringResource(R.string.new_item_screen_title),
            subtitle = stringResource(R.string.new_item_screen_subtitle),
        )
        ItemForm(
            uiState = uiState.newItem,
            onFieldChange = onFieldChange,
        )
        Spacer(modifier = Modifier.weight(FULL_WEIGHT))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.spacing_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.spacing_small),
                Alignment.CenterHorizontally,
            ),
        ) {
            Button(
                onClick = { onCancelButtonClick(uiState) },
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_button_height)),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier
                    .weight(HALF_WEIGHT)
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.spacing_button_height)),
            ) {
                Text(text = stringResource(R.string.cancel_button_label).uppercase())
            }
            Button(
                onClick = { onSaveButtonClick(uiState.newItem) },
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_button_height)),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier
                    .weight(HALF_WEIGHT)
                    .fillMaxWidth().
                    height(dimensionResource(id = R.dimen.spacing_button_height)),
                enabled = uiState.isSaveButtonEnabled,
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
        uiState = ShoppingListUiState(emptyList(), ItemUiState()),
        onSaveButtonClick = {},
        onCancelButtonClick = {},
        onFieldChange = {},
    )
}