package ru.mts.display_text.domain

import androidx.fragment.app.Fragment
import ru.mts.core.Feature
import ru.mts.core.FeatureManager
import ru.mts.core.base.IFeature
import ru.mts.core.di.Injector
import ru.mts.display_text.di.DaggerDisplayTextComponent
import ru.mts.display_text.presentation.DisplayTextFragment
import ru.mts.text_repository.ITextRepository

class DisplayTextFeature(
    override val dependencies: Dependencies,
    override val output: Output
) : Feature<DisplayTextFeature.Dependencies, DisplayTextFeature.Output, DisplayTextFeature.Api> {

    private val injector = object : Injector<DisplayTextFragment>(DisplayTextFragment::class.java) {
        private val daggerComponent = DaggerDisplayTextComponent
            .builder()
            .dependencies(dependencies)
            .build()

        override fun inject(objectToInject: DisplayTextFragment) {
            daggerComponent.inject(objectToInject)
        }
    }

    init {
        val registeredTag = FeatureManager.registerInjector(injector)
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
