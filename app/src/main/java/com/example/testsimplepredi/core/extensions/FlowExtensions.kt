package com.example.testsimplepredi.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

@Suppress("unused")
fun <T> MutableSharedFlow<T>.asSharedFlowIn(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(5_000),
    replay: Int = 0
): SharedFlow<T> {
    return asSharedFlow().shareIn(scope, started, replay)
}

@Suppress("unused")
fun <T> MutableStateFlow<T>.asStateFlowIn(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(5_000),
    initialValue: T
): StateFlow<T> {
    return asStateFlow().stateIn(scope, started, initialValue)
}
