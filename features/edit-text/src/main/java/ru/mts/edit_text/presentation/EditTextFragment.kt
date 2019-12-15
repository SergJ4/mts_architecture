package ru.mts.edit_text.presentation

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.edit_text_layout.*
import ru.mts.core.base.BaseFragment
import ru.mts.edit_text.R

class EditTextFragment : BaseFragment<IEditTextViewModel>() {
    override val layout: Int
        get() = R.layout.edit_text_layout

    override fun subscribeToViewModel() {
        viewModel
            .currentText
            .observe(viewLifecycleOwner, Observer { newText ->
                if (newText != textInput.text.toString()) {
                    textInput.setText(newText)
                    textInput.setSelection(newText.length)
                }
            })

        textInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(newText: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.newText(newText.toString())
            }
        })
    }
}
