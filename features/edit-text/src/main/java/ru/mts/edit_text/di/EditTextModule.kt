package ru.mts.edit_text.di

import dagger.Module
import dagger.Provides
import ru.mts.core.di.FeatureScope
import ru.mts.edit_text.domain.EditTextFeature
import ru.mts.edit_text.presentation.EditTextViewModel
import ru.mts.edit_text.presentation.IEditTextViewModel

@Module
class EditTextModule {

    @Provides
    @FeatureScope
    fun provideViewModel(
        dependencies: EditTextFeature.Dependencies,
        output: EditTextFeature.Output
    ): IEditTextViewModel = EditTextViewModel(dependencies.textRepository(), output)
}
