package ru.mts.architecture.di

import dagger.BindsInstance
import dagger.Component
import ru.mts.architecture.MainActivity
import ru.mts.core.di.ActivityScope

@Component(
    modules = [MainActivityModule::class],
    dependencies = [AppComponent::class]
)
@ActivityScope
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): MainActivityComponent
    }
}
