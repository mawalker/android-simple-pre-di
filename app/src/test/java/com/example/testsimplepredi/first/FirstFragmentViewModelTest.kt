package com.example.testsimplepredi.first

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testsimplepredi.core.testing.MainCoroutineRule
import com.example.testsimplepredi.core.testing.TestApplication
import com.example.testsimplepredi.repositories.MainFragmentsRepoInterface
import io.mockk.every
import io.mockk.mockk
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApplication::class, sdk = [33])
@ExperimentalCoroutinesApi
class FirstFragmentViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val mockkRule = MockKRule(this)

    private val mainFragmentsRepo: MainFragmentsRepoInterface = mockk(relaxed = true)

    private lateinit var viewModel: FirstFragmentViewModel

    @Before
    fun setUp() {

    }

    @Test
    fun onUpdatePressedTest() {
        val startString = "start_string"
        val endString = "end_string"

        // GIVEN
        every { mainFragmentsRepo.getLoremIpsum() } returns startString
        every { mainFragmentsRepo.getHelloWorld(any()) } returns endString

        initViewModel()

        // VERIFY START STATE
        assertEquals(startString, viewModel.viewStateFlow.value.textContent)

        // WHEN
        viewModel.onUpdateButtonPressed()

        // THEN
        assertEquals(endString, viewModel.viewStateFlow.value.textContent)
    }

    private fun initViewModel(){
        viewModel = FirstFragmentViewModel(mainFragmentsRepo = mainFragmentsRepo)
    }
}