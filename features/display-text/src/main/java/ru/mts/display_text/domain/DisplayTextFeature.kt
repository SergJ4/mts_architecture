package ru.mts.display_text.domain

import androidx.fragment.app.Fragment
import io.reactivex.Observable
import ru.mts.core.Feature
import ru.mts.core.FeatureManager
import ru.mts.core.base.IFeature
import ru.mts.text_repository.ITextRepository

class DisplayTextFeature(
    override val dependencies: Dependencies,
    override val output: Output
) : Feature<DisplayTextFeature.Dependencies, DisplayTextFeature.Output, DisplayTextFeature.Api> {

    init {
        FeatureManager.registerInjector
    }

    override val api: Api = DisplayTextFeatureApi(dependencies)

    interface Dependencies : IFeature.Dependencies {
        val textRepository: ITextRepository
    }

    interface Output : IFeature.Output {
        fun goToNextScreen()
    }

    interface Api : IFeature.Api {
        val fragment: Fragment
    }
}
