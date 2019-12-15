package ru.mts.display_text.di

import dagger.BindsInstance
import dagger.Component
import ru.mts.core.di.FeatureScope
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.display_text.presentation.DisplayTextFragment

@Component(
    dependencies = [DisplayTextFeature.Dependencies::class],
    modules = [DisplayTextModule::class]
)
@FeatureScope
internal interface DisplayTextComponent {

    fun inject(fragment: DisplayTextFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun output(featureOutput: DisplayTextFeature.Output): Builder

        fun dependencies(dependencies: DisplayTextFeature.Dependencies): Builder

        fun build(): DisplayTextComponent
    }
}
