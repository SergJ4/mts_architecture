package ru.mts.display_text.presentation

import androidx.lifecycle.LiveData
import ru.mts.core.base.IBaseViewModel

interface IDisplayTextViewModel : IBaseViewModel {

    val textToDisplay: LiveData<String>
}
