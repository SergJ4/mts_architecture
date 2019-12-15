package ru.mts.edit_text.domain

import androidx.fragment.app.Fragment
import ru.mts.core.Feature
import ru.mts.core.FeatureManager
import ru.mts.core.base.IFeature
import ru.mts.core.di.Injector
import ru.mts.edit_text.di.DaggerEditTextComponent
import ru.mts.edit_text.presentation.EditTextFragment
import ru.mts.text_repository.ITextRepository

class EditTextFeature(
    override val dependencies: Dependencies,
    override val output: Output
) : Feature<EditTextFeature.Dependencies, EditTextFeature.Output, EditTextFeature.Api>() {

    override val featureTag: String =
        javaClass.canonicalName ?: "EditTextFeature" + FeatureManager.getTag()

    override val api: Api = EditTextFeatureApi(featureTag)

    private val injector: Injector<EditTextFragment> = object : Injector<EditTextFragment>(
        EditTextFragment::class.java
    ) {
        private val component = DaggerEditTextComponent
            .builder()
            .dependencies(dependencies)
            .output(output)
            .build()

        override fun inject(objectToInject: EditTextFragment) {
            component.inject(objectToInject)
        }
    }

    interface Dependencies : IFeature.Dependencies {
        fun textRepository(): ITextRepository
    }

    interface Output : IFeature.Output

    interface Api : IFeature.Api {
        val fragment: Fragment
    }

    init {
        FeatureManager.register(this)
    }

    override fun getInjectorFor(objectToInjectInto: Any): Injector<*> {
        if (objectToInjectInto !is EditTextFragment)
            throw IllegalArgumentException("Can not inject into $objectToInjectInto")

        return injector
    }

    override fun destroy(destroyedObject: Any) {
        FeatureManager.remove(this)
    }
}