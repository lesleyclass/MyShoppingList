package com.example.myshoppinglist.arch

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

internal interface UiEvent<T> {

    val eventFlow: SharedFlow<T>

    suspend fun sendEvent(event: T)
}

internal class UiEventImpl<T> : UiEvent<T> {

    override val eventFlow = MutableSharedFlow<T>()

    override suspend fun sendEvent(event: T) {
        eventFlow.emit(event)
    }
}
