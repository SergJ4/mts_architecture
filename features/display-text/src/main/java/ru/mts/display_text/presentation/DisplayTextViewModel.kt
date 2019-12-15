package ru.mts.display_text.presentation

import androidx.lifecycle.LiveData
import ru.mts.core.base.BaseViewModel
import ru.mts.core.toLiveData
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.text_repository.ITextRepository

internal class DisplayTextViewModel(
    private val textRepository: ITextRepository,
    output: DisplayTextFeature.Output
) : BaseViewModel<DisplayTextFeature.Output>(output), IDisplayTextViewModel {

    override val textToDisplay: LiveData<String> by lazy {
        textRepository
            .currentText
            .toLiveData()
    }

    override fun textClicked() {
        output.goToNextScreen()
    }

    override fun initializeViewModel() {
    }
}
