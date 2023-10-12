package com.example.myshoppinglist

import com.example.myshoppinglist.domain.ItemField
import com.example.myshoppinglist.fake.randomDouble
import com.example.myshoppinglist.fake.randomInt
import com.example.myshoppinglist.fake.randomName
import com.example.myshoppinglist.rule.MainDispatcherRule
import com.example.myshoppinglist.ui.composable.shoppinglist.OnFieldChange
import com.example.myshoppinglist.ui.composable.shoppinglist.OnSaveNewItemClick
import com.example.myshoppinglist.ui.store.ItemsStore
import com.example.myshoppinglist.validation.ButtonValidation
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@Suppress("UnnecessaryVariable")
@OptIn(ExperimentalCoroutinesApi::class)
internal class ShoppingListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun onSaveNewItemClick_shouldInsertItem() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val itemUiState = randomItemUiState()
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnSaveNewItemClick(itemUiState))

        verify(exactly = 1) {
            itemsStore.insertItem(itemUiState)
        }
    }

    @Test
    fun onCreateNewItemClick_shouldTrackClickBackAction() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val itemUiState = randomItemUiState()
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnSaveNewItemClick(itemUiState))

        verify(exactly = 1) {
            itemsStore.insertItem(itemUiState)
        }
    }

    @Test
    fun onFieldChange_withNameItemField_shouldUpdateNewItemState() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val name = randomName()
        val field = ItemField.Name(name)
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnFieldChange(field))

        val actual = viewModel.stateFlow.value.newItem.name
        val expected = name
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun onFieldChange_withValueItemField_shouldUpdateNewItemState() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val value = "${randomDouble()}"
        val field = ItemField.Value(value)
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnFieldChange(field))

        val actual = viewModel.stateFlow.value.newItem.value.toString()
        val expected = value
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun onFieldChange_withQuantityItemField_shouldUpdateNewItemState() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val quantity = "${randomInt()}"
        val field = ItemField.Quantity(quantity)
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnFieldChange(field))

        val actual = viewModel.stateFlow.value.newItem.quantity.toString()
        val expected = quantity
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun onFieldChange_withTotalValueItemField_shouldUpdateNewItemState() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val totalValue = "${randomDouble()}"
        val field = ItemField.TotalValue(totalValue)
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnFieldChange(field))

        val actual = viewModel.stateFlow.value.newItem.totalValue.toString()
        val expected = totalValue
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun onFieldChange_withDescriptionItemField_shouldUpdateNewItemState() = runTest {
        val initialState = randomShoppingListUiState()
        val itemsStore: ItemsStore = mockk(relaxed = true)
        val saveButtonValidation: ButtonValidation = mockk(relaxed = true)
        val description = "${randomDouble()}"
        val field = ItemField.Description(description)
        val viewModel = ShoppingListViewModel(
            initialState = initialState,
            itemsStore = itemsStore,
            saveButtonValidation = saveButtonValidation,
        )

        viewModel.onSendEvent(OnFieldChange(field))

        val actual = viewModel.stateFlow.value.newItem.description
        val expected = description
        assertThat(actual).isEqualTo(expected)
    }
}