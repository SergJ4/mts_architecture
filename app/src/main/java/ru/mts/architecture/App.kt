package ru.mts.architecture

import android.app.Application
import ru.mts.architecture.di.AppComponent
import ru.mts.architecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
