package com.example.myshoppinglist.ui.composable.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.R

@Composable
internal fun TopAppBar(
    titleRes: Int,
    @DrawableRes navigationIconRes: Int,
    onNavigationIconClick: () -> Unit,
    tag: String,
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = titleRes))
        },
        backgroundColor = MaterialTheme.colors.secondary,
        navigationIcon = {
            IconButton(onClick = { onNavigationIconClick() }) {
                Icon(
                    painter = painterResource(id = navigationIconRes),
                    contentDescription = stringResource(id = R.string.item_total_value_label),
                )
            }
        },
        modifier = Modifier.testTag(tag),
    )
}

@Preview
@Composable
internal fun TopAppBarPreview() {
    TopAppBar(
        titleRes = R.string.toolbar_title,
        navigationIconRes = R.drawable.ic_baseline_close,
        onNavigationIconClick = {},
        tag = "",
    )
}