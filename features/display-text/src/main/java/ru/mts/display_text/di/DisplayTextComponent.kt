package ru.mts.display_text.di

import dagger.Component
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.display_text.presentation.DisplayTextFragment

@Component(
    dependencies = [DisplayTextFeature.Dependencies::class],
    modules = [DisplayTextModule::class]
)
internal interface DisplayTextComponent {

    fun inject(fragment: DisplayTextFragment)
}
