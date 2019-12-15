package ru.mts.display_text.domain

import androidx.fragment.app.Fragment
import ru.mts.display_text.presentation.DisplayTextFragment

internal class DisplayTextFeatureApi(
    dependencies: DisplayTextFeature.Dependencies,
    private val featureTag: String
) : DisplayTextFeature.Api {

    override val fragment: Fragment
        get() = DisplayTextFragment()
            .apply {
                featureTag = this@DisplayTextFeatureApi.featureTag
            }
}
