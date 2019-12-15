package ru.mts.display_text.di

import dagger.Module
import dagger.Provides
import ru.mts.core.di.FeatureScope
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.display_text.presentation.DisplayTextViewModel
import ru.mts.display_text.presentation.IDisplayTextViewModel
import ru.mts.text_repository.TextRepository

@Module
internal class DisplayTextModule {

    @Provides
    @FeatureScope
    internal fun provideViewModel(
        textRepository: TextRepository,
        output: DisplayTextFeature.Output
    ): IDisplayTextViewModel = DisplayTextViewModel(textRepository, output)
}
