package ru.mts.architecture.di

import dagger.Component
import ru.mts.text_repository.ITextRepository
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun provideTextRepository(): ITextRepository

    fun provideRouter(): Router

    fun provideNavigatorHolder(): NavigatorHolder
}
