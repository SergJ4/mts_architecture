package ru.mts.edit_text.di

import dagger.BindsInstance
import dagger.Component
import ru.mts.core.di.FeatureScope
import ru.mts.edit_text.domain.EditTextFeature
import ru.mts.edit_text.presentation.EditTextFragment

@Component(
    dependencies = [EditTextFeature.Dependencies::class],
    modules = [EditTextModule::class]
)
@FeatureScope
interface EditTextComponent {

    fun inject(fragment: EditTextFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun output(featureOutput: EditTextFeature.Output): Builder

        fun dependencies(dependencies: EditTextFeature.Dependencies): Builder

        fun build(): EditTextComponent
    }
}