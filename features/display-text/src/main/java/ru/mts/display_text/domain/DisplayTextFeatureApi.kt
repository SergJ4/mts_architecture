package ru.mts.display_text.domain

import androidx.fragment.app.Fragment
import ru.mts.display_text.presentation.DisplayTextFragment

internal class DisplayTextFeatureApi(
    dependencies: DisplayTextFeature.Dependencies,
    injectorTag: Int
) : DisplayTextFeature.Api {

    override val fragment: Fragment = DisplayTextFragment()
        .apply {
            tag = injectorTag
        }
}
