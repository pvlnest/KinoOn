package com.pvl.nest.kinoon.feature.errors_screen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pvl.nest.kinoon.R
import com.pvl.nest.kinoon.base.utils.setThrottledClickListener
import com.pvl.nest.kinoon.databinding.FragmentErrorsScreenBinding
import com.pvl.nest.kinoon.feature.movies_screen.ui.MoviesListViewModel
import com.pvl.nest.kinoon.feature.movies_screen.ui.UiEvent
import com.pvl.nest.kinoon.feature.movies_screen.ui.ViewState
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ErrorsScreenFragment : Fragment(R.layout.fragment_errors_screen) {
    companion object {
        fun newInstance() = ErrorsScreenFragment()
    }

    private val binding: FragmentErrorsScreenBinding by viewBinding(FragmentErrorsScreenBinding::bind)
    private val viewModel: MoviesListViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun render(viewState: ViewState) {
        with(binding) {
            errorText.text = getString(R.string.error_text)
            retryButton.setThrottledClickListener {
                viewModel.processUiEvent(UiEvent.OnRetryClicked)
            }
        }
    }
}