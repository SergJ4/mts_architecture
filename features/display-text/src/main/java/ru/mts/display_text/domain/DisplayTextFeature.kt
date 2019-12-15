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
) : Feature<DisplayTextFeature.Dependencies, DisplayTextFeature.Output, DisplayTextFeature.Api>() {

    override val featureTag: String =
        javaClass.canonicalName ?: "DisplayTextFeature" + FeatureManager.getTag()

    private val injector = object : Injector<DisplayTextFragment>(DisplayTextFragment::class.java) {
        private val daggerComponent = DaggerDisplayTextComponent
            .builder()
            .dependencies(dependencies)
            .output(output)
            .build()

        override fun inject(objectToInject: DisplayTextFragment) {
            daggerComponent.inject(objectToInject)
        }
    }

    override val api: Api = DisplayTextFeatureApi(dependencies, featureTag)

    init {
        FeatureManager.register(this)
    }

    override fun getInjectorFor(objectToInjectInto: Any): Injector<*> {
        if (objectToInjectInto !is DisplayTextFragment)
            throw IllegalArgumentException("Can not inject into $objectToInjectInto")

        return injector
    }

    override fun destroy(destroyedObject: Any) {
        if (destroyedObject is DisplayTextFragment) {
            FeatureManager.remove(this)
        }
    }

    interface Dependencies : IFeature.Dependencies {
        fun textRepository(): ITextRepository
    }

    interface Output : IFeature.Output {
        fun goToNextScreen()
    }

    interface Api : IFeature.Api {
        val fragment: Fragment
    }
}
