package ru.mts.architecture

import androidx.lifecycle.ViewModel
import ru.mts.architecture.navigation.MainActivityRouter

class MainActivityViewModel(
    private val router: MainActivityRouter
) : ViewModel() {

    fun start() {
        router.openDisplayTextScreen()
    }
}
