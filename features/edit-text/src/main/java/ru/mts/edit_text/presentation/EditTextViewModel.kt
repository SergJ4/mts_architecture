package ru.mts.edit_text.presentation

import androidx.lifecycle.LiveData
import ru.mts.core.base.BaseViewModel
import ru.mts.core.toLiveData
import ru.mts.edit_text.domain.EditTextFeature
import ru.mts.text_repository.ITextRepository

class EditTextViewModel(
    private val repository: ITextRepository,
    output: EditTextFeature.Output
) : IEditTextViewModel, BaseViewModel<EditTextFeature.Output>(output) {

    override val currentText: LiveData<String> by lazy {
        repository
            .currentText
            .distinctUntilChanged()
            .toLiveData()
    }

    override fun newText(newText: String) {
        repository.setNewText(newText)
    }

    override fun initializeViewModel() {
    }
}