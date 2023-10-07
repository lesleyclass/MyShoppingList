package com.example.myshoppinglist.ui

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

internal interface UiEffect<T> {

    val effectFlow: SharedFlow<T>

    suspend fun sendEffect(effect: T)
}

internal class UiEffectImpl<T> : UiEffect<T> {

    override val effectFlow = MutableSharedFlow<T>()

    override suspend fun sendEffect(effect: T) {
        effectFlow.emit(effect)
    }
}
