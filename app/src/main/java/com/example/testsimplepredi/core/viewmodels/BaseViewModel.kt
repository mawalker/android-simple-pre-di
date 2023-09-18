package com.example.testsimplepredi.core.viewmodels


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.testsimplepredi.core.extensions.asStateFlowIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

interface ViewState
interface ViewEvent
interface ViewEffect

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewEffect> :
    ViewModel() {

    private val _initialState: UiState by lazy { getInitialState() }

    /*
     * Note: The following code is more efficient(readability) once entire app is moved to Compose
     * However, for now StateFlow is still perfectly acceptable
     */

    internal val viewStateFlow = MutableStateFlow(_initialState)
    val viewState: Flow<UiState?> = viewStateFlow.asStateFlowIn(viewModelScope, initialValue = _initialState)


    private val _effect = MutableStateFlow<Effect?>(null)
    val effect: Flow<Effect?> = _effect.asStateFlowIn(viewModelScope, initialValue = null)

    abstract fun processEvent(event: Event)

    protected fun setState(reducer: UiState.() -> UiState) {
        reduceState(reducer)
    }

    protected fun setEffect(effect: Effect) {
        _effect.value = effect
    }

    fun markEffectAsConsumed() {
        _effect.value = null
    }

    abstract fun getInitialState(): UiState

    protected fun Effect.send() = setEffect(this)

    private fun reduceState(reducer: (oldState: UiState) -> UiState) {
        viewModelScope.launch {
            val oldState = viewStateFlow.value
            viewStateFlow.value = reducer(oldState)
        }
    }
}

