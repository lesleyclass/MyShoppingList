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
import com.example.myshoppinglist.ui.ItemField

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
            labelRes = R.string.item_name_form,
            content = {
                OutlinedTextField(
                    value = uiState.name ?: "",
                    onValueChange = {
                        onFieldChange( ItemField.Name(it.ifBlank { null }))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_value_form,
            content = {
                OutlinedTextField(
                    value = uiState.value?.toString() ?: "",
                    onValueChange = {
                        onFieldChange( ItemField.Value(it.ifBlank { null }))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_quantity_form,
            content = {
                OutlinedTextField(
                    value = uiState.quantity?.toString() ?: "",
                    onValueChange = {
                        onFieldChange( ItemField.Quantity(it.ifBlank { null }))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_totalValue_form,
            content = {
                OutlinedTextField(
                    value = uiState.totalValue?.toString() ?: "",
                    onValueChange = {
                        onFieldChange( ItemField.TotalValue(it.ifBlank { null }))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_description_form,
            content = {
                OutlinedTextField(
                    value = uiState.description ?: "",
                    onValueChange = {
                        onFieldChange( ItemField.Description(it.ifBlank { null }))
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            },
        )
    }
}

@Composable
private fun ItemFormTextField(
    labelRes: Int,
    content: @Composable (() -> Unit),
) {
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
        content()
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
