package ru.mts.architecture.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import ru.mts.architecture.MainActivity
import ru.mts.architecture.MainActivityViewModel
import ru.mts.architecture.navigation.DisplayTextFeatureRouter
import ru.mts.architecture.navigation.EditTextRouter
import ru.mts.architecture.navigation.MainActivityRouter
import ru.mts.core.di.ActivityScope
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.edit_text.domain.EditTextFeature
import ru.mts.text_repository.ITextRepository
import ru.terrakok.cicerone.Router
import javax.inject.Provider

@Module
class MainActivityModule {

    @Provides
    fun provideDisplayTextFeature(
        textRepository: ITextRepository,
        displayTextFeatureOutput: DisplayTextFeatureRouter
    ): DisplayTextFeature = DisplayTextFeature(
        object : DisplayTextFeature.Dependencies {
            override fun textRepository(): ITextRepository = textRepository
        },
        displayTextFeatureOutput
    )

    @Provides
    fun provideEditTextFeature(
        textRepository: ITextRepository,
        editTextFeatureOutput: EditTextRouter
    ): EditTextFeature = EditTextFeature(
        object : EditTextFeature.Dependencies {
            override fun textRepository(): ITextRepository = textRepository
        },
        editTextFeatureOutput
    )

    @Provides
    @ActivityScope
    fun provideRouter(
        featureProvider: Provider<DisplayTextFeature>,
        router: Router
    ): MainActivityRouter = MainActivityRouter(featureProvider, router)

    @Provides
    @ActivityScope
    fun provideDisplayTextFeatureRouter(
        router: Router,
        provider: Provider<EditTextFeature>
    ): DisplayTextFeatureRouter = DisplayTextFeatureRouter(router, provider)

    @Provides
    @ActivityScope
    fun provideEditTextFeatureRouter(router: Router): EditTextRouter = EditTextRouter(router)

    @Provides
    @ActivityScope
    fun provideViewModel(
        router: MainActivityRouter,
        activity: MainActivity
    ): MainActivityViewModel {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(router) as T
            }
        }

        return ViewModelProviders.of(activity, factory)[MainActivityViewModel::class.java]
    }
}