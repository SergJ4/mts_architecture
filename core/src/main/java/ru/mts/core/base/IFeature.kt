package ru.mts.core.base

import androidx.fragment.app.Fragment

interface IFeature<OUT : IFeature.Output, DEPS : IFeature.Dependencies, API: IFeature.Api> {

    val dependencies: DEPS

    interface Dependencies

    interface Api

    interface Output {
        fun back()
    }
}
