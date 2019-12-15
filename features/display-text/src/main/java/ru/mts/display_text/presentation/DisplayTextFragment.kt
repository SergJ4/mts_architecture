package ru.mts.display_text.presentation

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.display_text_layout.*
import ru.mts.core.base.BaseFragment
import ru.mts.display_text.R

class DisplayTextFragment : BaseFragment<IDisplayTextViewModel>() {

    override val layout: Int
        get() = R.layout.display_text_layout

    override fun subscribeToViewModel() {
        viewModel
            .textToDisplay
            .observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
    }
}
