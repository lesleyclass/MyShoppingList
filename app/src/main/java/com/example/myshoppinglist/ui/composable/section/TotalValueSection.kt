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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.R

internal const val TOTAL_VALUE_SECTION_TAG = "TotalValueSection"

@Composable
internal fun TotalValueSection(
    label: String = stringResource(id = R.string.total_value_label_text),
    value: Double,
) {
    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.purple_700).copy(alpha = 0.3f))
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp,
            )
            .testTag(TOTAL_VALUE_SECTION_TAG),
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
        )
        Spacer(modifier = Modifier.weight(1f))
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