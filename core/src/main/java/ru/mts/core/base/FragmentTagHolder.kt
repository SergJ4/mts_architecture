package ru.mts.core.base

import android.os.Bundle
import kotlin.reflect.KProperty

private const val TAG_ARGUMENT = "fragment_feature_tag_argument"

class FragmentTagHolder {
    operator fun getValue(baseFragment: BaseFragment<*>, property: KProperty<*>): String {
        return baseFragment
            .arguments
            ?.getString(TAG_ARGUMENT)
            ?: throw IllegalStateException("Tag was not installed when $baseFragment created")
    }

    operator fun setValue(baseFragment: BaseFragment<*>, property: KProperty<*>, newTag: String) {
        baseFragment
            .arguments
            ?.putString(TAG_ARGUMENT, newTag)
            ?: run {
                baseFragment.arguments = Bundle()
                    .apply {
                        putString(TAG_ARGUMENT, newTag)
                    }
            }
    }
}
