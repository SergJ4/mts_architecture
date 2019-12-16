package ru.mts.architecture.di

import dagger.Module
import dagger.Provides
import ru.mts.text_repository.ITextRepository
import ru.mts.text_repository.domain.TextRepositoryFeature
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideTextRepository(): ITextRepository = TextRepositoryFeature().api.textRepository()

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder
}
