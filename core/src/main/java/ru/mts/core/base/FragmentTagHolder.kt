package ru.mts.core.base

import android.os.Bundle
import kotlin.reflect.KProperty

private const val TAG_ARGUMENT = "fragment_feature_tag_argument"

class FragmentTagHolder {
    operator fun getValue(baseFragment: BaseFragment<*>, property: KProperty<*>): Int {
        return baseFragment
            .arguments
            ?.getInt(TAG_ARGUMENT)
            ?: throw IllegalStateException("Tag was not installed when $baseFragment created")
    }

    operator fun setValue(baseFragment: BaseFragment<*>, property: KProperty<*>, newTag: Int) {
        baseFragment
            .arguments
            ?.putInt(TAG_ARGUMENT, newTag)
            ?: run {
                baseFragment.arguments = Bundle()
                    .apply {
                        putInt(TAG_ARGUMENT, newTag)
                    }
            }
    }
}
