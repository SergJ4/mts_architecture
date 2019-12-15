package ru.mts.display_text.di

import dagger.Component
import ru.mts.display_text.domain.DisplayTextFeature

@Component(
    dependencies = [DisplayTextFeature.Dependencies::class],
    modules = [DisplayTextModule::class]
)
internal interface DisplayTextComponent
