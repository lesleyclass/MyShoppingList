package com.example.myshoppinglist.ui.composable.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ui.composable.item.FULL_WEIGHT

internal const val TOTAL_VALUE_SECTION_TAG = "TotalValueSection"
internal const val HALF_ALPHA = 0.5f

@Composable
internal fun TotalValueSection(
    label: String = stringResource(id = R.string.total_value_label_text),
    value: Double,
) {
    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.purple_700).copy(alpha = HALF_ALPHA))
            .padding(
                vertical = dimensionResource(id = R.dimen.spacing_small),
                horizontal = dimensionResource(id = R.dimen.spacing_standard),
            )
            .testTag(TOTAL_VALUE_SECTION_TAG),
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
        )
        Spacer(modifier = Modifier.weight(FULL_WEIGHT))
        Text(
            text = stringResource(
                id = R.string.item_value_label,
                value,
            ),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun TotalValueSectionPreview() {
    TotalValueSection(value = 0.0)
}