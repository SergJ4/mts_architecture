package ru.mts.edit_text.presentation

import androidx.lifecycle.LiveData
import ru.mts.core.base.IBaseViewModel

interface IEditTextViewModel : IBaseViewModel {
    fun newText(newText: String)

    val currentText: LiveData<String>
}
