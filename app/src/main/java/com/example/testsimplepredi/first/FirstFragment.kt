package com.example.testsimplepredi.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.testsimplepredi.R
import com.example.testsimplepredi.databinding.FragmentFirstBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val viewModel: FirstFragmentViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    /**
     * Initialize Observers
     */
    private fun initObservers() {

//        lifecycleScope.launch {
//            viewModel.viewState.collect()
//        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Create a new coroutine since repeatOnLifecycle is a suspend function
        viewLifecycleOwner.lifecycleScope.launch {
            // The block passed to repeatOnLifecycle is executed when the lifecycle
            // is at least STARTED and is cancelled when the lifecycle is STOPPED.
            // It automatically restarts the block when the lifecycle is STARTED again.
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // {code to collect from viewModel}
                // Safely collect from locationFlow when the lifecycle is STARTED
                // and stops collection when the lifecycle is STOPPED
                viewModel.effect.collect{effect ->
                    when (effect){
                        is FirstFragmentUIContract.UiEffect.ShowToast -> showToast(effect.toastMessage)
                        else -> {}
                    }
                }

                viewModel.viewState
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect {
                    if (it != null) {
                        updateText(it.textContent)

                    }
                }
            }
        }


        binding.buttonFirst.setOnClickListener {
            viewModel.onNextButtonPressed()
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonUpdate.setOnClickListener {
            viewModel.onUpdateButtonPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /**
     * Show simple toast message
     */
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun updateText(message : String){
        binding.textviewFirst.text = message
    }
}