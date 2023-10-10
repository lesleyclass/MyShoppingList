package com.example.myshoppinglist.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.CreateNewItem
import com.example.myshoppinglist.ui.composable.toolbar.TopAppBar
import com.example.myshoppinglist.ui.navigation.ShoppingListNavigator
import kotlinx.coroutines.flow.collect

private const val SHOPPING_LIST_SCREEN_TAG = "ShoppingListScreen"
private const val SHOPPING_LIST_SCREEN_TITLE_TAG = "ShoppingListScreenTitle"
private const val BUTTON_TAG = "Button"

@Composable
internal fun ShoppingListScreen(
    viewModel: ShoppingListViewModel,
    navigator: ShoppingListNavigator,
){
    val uiState by viewModel.stateFlow.collectAsState()

    ShoppingListScreen(
        uiState = uiState,
        onCreateNewItemClick = {},
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.effectFlow.collect{ effect ->
            when (effect) {
                is CreateNewItem -> {}
            }
        }
    }
}

@Composable
internal fun ShoppingListScreen(
    uiState: ShoppingListUiState,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onCreateNewItemClick: () -> Unit,
){
    Scaffold(
        modifier = Modifier.testTag(SHOPPING_LIST_SCREEN_TAG),
        topBar = {
            TopAppBar(
                titleRes = R.string.toolbar_title,
                navigationIconRes = R.drawable.ic_baseline_close,
                onNavigationIconClick = {},
                tag = SHOPPING_LIST_SCREEN_TITLE_TAG,
            )
        },
        scaffoldState = scaffoldState,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { onCreateNewItemClick() },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.button_content_description),
                    )
                },
                text = { Text(text = stringResource(id = R.string.button_label)) },
                modifier = Modifier.testTag(BUTTON_TAG),
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
            ) {
                ShoppingListContent(
                    uiState = uiState,
                )
            }
        }
    )
}

@Preview
@Composable
internal fun ShoppingListScreenPreview(){
    ShoppingListScreen(
        uiState = ShoppingListUiState(emptyList()),
        onCreateNewItemClick = {},
    )
}
