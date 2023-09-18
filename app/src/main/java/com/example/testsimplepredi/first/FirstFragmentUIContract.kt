package com.example.testsimplepredi.first

import androidx.annotation.StringRes
import com.example.testsimplepredi.core.viewmodels.ViewEffect
import com.example.testsimplepredi.core.viewmodels.ViewEvent
import com.example.testsimplepredi.core.viewmodels.ViewState


object FirstFragmentUIContract {

    data class UIState(
        val fragmentLabel: String = "",
        val textContent: String = "",
    ) : ViewState

    // For future use (Compose)
    sealed class UiEffect(@StringRes open val message: Int? = null) : ViewEffect {
        data class ShowToast(val toastMessage: String) : UiEffect()
    }

    sealed class UiEvent : ViewEvent {

        data object NavigateToSecondFragment : UiEvent()
        data class OnErrorRetrievingData(val errorMessage: String) : UiEvent()

    }
}

