package com.example.myshoppinglist.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal interface UiState<T> {

    val stateFlow: StateFlow<T>

    fun setState(block: T.() -> T)
}

internal class UiStateImpl<T>(value: T) : UiState<T> {

    override val stateFlow = MutableStateFlow(value)

    override fun setState(block: T.() -> T) {
        stateFlow.value = stateFlow.value.block()
    }
}
