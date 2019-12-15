package ru.mts.architecture.navigation

import androidx.fragment.app.Fragment
import ru.mts.display_text.domain.DisplayTextFeature
import ru.mts.edit_text.domain.EditTextFeature
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Provider

class DisplayTextFeatureRouter(
    private val router: Router,
    private val featureProvider: Provider<EditTextFeature>
) : DisplayTextFeature.Output {

    override fun goToNextScreen() = router.navigateTo(object : SupportAppScreen() {
        override fun getFragment(): Fragment = featureProvider
            .get()
            .api
            .fragment
    })

    override fun back() = router.exit()
}
