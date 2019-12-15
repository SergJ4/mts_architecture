package ru.mts.display_text.domain

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.mts.text_repository.TextRepository
import ru.mts.display_text.presentation.DisplayTextFragment

private const val INITIAL_TEXT_ARG = "initial_text_argument"

internal class DisplayTextFeatureApi(
    dependencies: DisplayTextFeature.Dependencies
) : DisplayTextFeature.Api {

    override val fragment: Fragment = DisplayTextFragment().apply {
        arguments = Bundle().apply {
            putString(INITIAL_TEXT_ARG, dependencies.initialString)
        }
    }

    override val textRepository: DisplayTextFeature.Api.TextRepository
        get() = ru.mts.text_repository.TextRepository()
}