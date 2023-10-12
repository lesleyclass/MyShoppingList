package com.example.myshoppinglist.ui.composable.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.R

internal const val SECTION_HEADER_SUBTITLE_TAG = "SectionHeaderSubtitle"
internal const val SECTION_HEADER_TAG = "SectionHeader"

@Composable
internal fun SectionHeader(
    title: String,
    subtitle: String? = null,
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .testTag(SECTION_HEADER_TAG),
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(4.dp))
        subtitle?.let { Text(
            text = it,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.testTag(SECTION_HEADER_SUBTITLE_TAG),
        ) }
    }
}


@Preview(showBackground = true)
@Composable
internal fun SectionHeaderPreview() {
    SectionHeader(
        title = stringResource(id = R.string.new_item_screen_title),
        subtitle = stringResource(R.string.new_item_screen_subtitle),
    )
}