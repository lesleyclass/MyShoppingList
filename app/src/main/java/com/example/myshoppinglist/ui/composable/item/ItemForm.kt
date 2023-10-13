package com.example.myshoppinglist.ui.composable.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.R
import com.example.myshoppinglist.domain.ItemField

internal const val ITEM_FORM_TAG = "ItemForm"

@Composable
internal fun ItemForm(
    uiState: ItemUiState,
    onFieldChange: (ItemField) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.spacing_small))
            .testTag(ITEM_FORM_TAG),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ItemFormTextField(
            labelRes = R.string.item_name_form,
            content = {
                OutlinedTextField(
                    value = uiState.name ?: "",
                    onValueChange = { onFieldChange( ItemField.Name(it.ifBlank { null })) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next,),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),

                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_value_form,
            content = {
                OutlinedTextField(
                    value = uiState.value?.toString() ?: "",
                    onValueChange = { onFieldChange(ItemField.Value(it.ifBlank { null })) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_quantity_form,
            content = {
                OutlinedTextField(
                    value = uiState.quantity?.toString() ?: "",
                    onValueChange = { onFieldChange(ItemField.Quantity(it.ifBlank { null })) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_total_value_form,
            content = {
                OutlinedTextField(
                    value = uiState.totalValue?.toString() ?: "",
                    onValueChange = { onFieldChange(ItemField.TotalValue(it.ifBlank { null })) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                )
            }
        )
        ItemFormTextField(
            labelRes = R.string.item_description_form,
            content = {
                OutlinedTextField(
                    value = uiState.description ?: "",
                    onValueChange = { onFieldChange( ItemField.Description(it.ifBlank { null })) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
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
                top = dimensionResource(id = R.dimen.spacing_tiny),
                bottom = dimensionResource(id = R.dimen.spacing_tiny),
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
