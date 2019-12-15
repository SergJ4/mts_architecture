package ru.mts.architecture.navigation

import androidx.fragment.app.Fragment
import ru.mts.display_text.domain.DisplayTextFeature
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Provider

class MainActivityRouter(
    private val featureProvider: Provider<DisplayTextFeature>,
    private val router: Router
) {

    fun openDisplayTextScreen() = router.newRootScreen(
        object : SupportAppScreen() {
            override fun getFragment(): Fragment = featureProvider
                .get()
                .api
                .fragment
        }
    )
}