package com.example.myshoppinglist.di

import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun uiModule (): Module = module {
    viewModel { (initialState: ShoppingListUiState) ->
        ShoppingListViewModel(
            initialState = initialState,
        )
    }
}
