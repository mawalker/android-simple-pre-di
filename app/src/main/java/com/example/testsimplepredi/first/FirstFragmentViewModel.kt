package com.example.testsimplepredi.first

import com.example.testsimplepredi.core.viewmodels.BaseViewModel
import com.example.testsimplepredi.repositories.MainFragmentsRepo
import com.example.testsimplepredi.repositories.MainFragmentsRepoInterface
import com.example.testsimplepredi.first.FirstFragmentUIContract.UIState
import com.example.testsimplepredi.first.FirstFragmentUIContract.UiEvent
import com.example.testsimplepredi.first.FirstFragmentUIContract.UiEffect

/**
 * ViewModel holds the state of the UI and doesn't die when Screen isn't visible like Fragments, etc.
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 *
 * This ViewModel makes use of the MVI pattern
 * https://proandroiddev.com/mvi-architecture-with-kotlin-flows-and-channels-d36820b2028d
 */
class FirstFragmentViewModel constructor(
    private val mainFragmentsRepo: MainFragmentsRepoInterface = MainFragmentsRepo()

) : BaseViewModel<UiEvent, UIState, UiEffect>() {

    init {
        setState {
            copy(
                fragmentLabel = mainFragmentsRepo.getFirstFragmentName(),
                textContent = mainFragmentsRepo.getLoremIpsum(),
            )
        }
    }

    private fun showToast(toastMessage: String) {

    }

    private fun navigateToSecondFragment() {

    }

    private fun onErrorRetrievingData(errorMessage: String) {

    }

    override fun processEvent(event: UiEvent) {
        when (event) {
            is UiEvent.OnErrorRetrievingData -> onErrorRetrievingData(event.errorMessage)
            is UiEvent.NavigateToSecondFragment -> navigateToSecondFragment()
        }
    }

    override fun getInitialState() = UIState()

    fun onNextButtonPressed() {

    }

    fun onUpdateButtonPressed(){
        setState {
            copy(
               textContent = mainFragmentsRepo.getHelloWorld(" Mike")
            )
        }
    }
}
