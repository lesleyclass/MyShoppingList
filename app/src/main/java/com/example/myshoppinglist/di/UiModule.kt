package com.example.myshoppinglist.di

import com.example.myshoppinglist.ShoppingListUiState
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.store.ItemsStore
import com.example.myshoppinglist.validation.ButtonValidation
import com.example.myshoppinglist.validation.SaveButtonValidation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun uiModule (): Module = module {
    single { ItemsStore() }

    factory<ButtonValidation> {
        SaveButtonValidation()
    }

    viewModel { (initialState: ShoppingListUiState) ->
        ShoppingListViewModel(
            initialState = initialState,
            itemsStore = get(),
            saveButtonValidation = get(),
        )
    }
}
