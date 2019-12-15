package ru.mts.edit_text.domain

import androidx.fragment.app.Fragment
import ru.mts.edit_text.presentation.EditTextFragment

class EditTextFeatureApi(private val featureTag: String) : EditTextFeature.Api {

    override val fragment: Fragment
        get() = EditTextFragment().apply {
            featureTag = this@EditTextFeatureApi.featureTag
        }
}