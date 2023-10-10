package com.example.myshoppinglist.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R

internal const val ITEM_FORM_TAG = "ItemForm"

@Composable
internal fun ItemForm(
    uiState: ItemUiState,
    onFieldChange: (ItemField) -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp).testTag(ITEM_FORM_TAG),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ItemFormTextField(
            value = uiState.name,
            labelRes = R.string.item_name_form,
            onFieldChange = { onFieldChange( ItemField.Name(it))},
        )
        ItemFormTextField(
            value = uiState.value.toString(),
            labelRes = R.string.item_value_form,
            onFieldChange = { onFieldChange( ItemField.Value(it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        ItemFormTextField(
            value = uiState.quantity.toString(),
            labelRes = R.string.item_quantity_form,
            onFieldChange = { onFieldChange( ItemField.Quantity(it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        ItemFormTextField(
            value = uiState.totalValue.toString(),
            labelRes = R.string.item_totalValue_form,
            onFieldChange = { onFieldChange( ItemField.TotalValue(it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        ItemFormTextField(
            value = uiState.description,
            labelRes = R.string.item_description_form,
            onFieldChange = { onFieldChange( ItemField.Description(it))},
        )
    }
}

internal sealed class ItemField{
    abstract val value: String

    class Name(override val value: String) : ItemField()
    class Value(override val value: String) : ItemField()
    class Quantity(override val value: String) : ItemField()
    class TotalValue(override val value: String) : ItemField()
    class Description(override val value: String) : ItemField()
}

@Composable
private fun ItemFormTextField(
    value: String,
    labelRes: Int,
    onFieldChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val itemValue by remember(value) { mutableStateOf(value) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = labelRes),
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 8.dp,
            ),
        )
        OutlinedTextField(
            value = itemValue,
            onValueChange = { onFieldChange(itemValue) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun ItemFormPreview() {
    ItemForm(
        uiState = ItemUiState(),
        onFieldChange = {},
    )
}
