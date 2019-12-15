package ru.mts.architecture.navigation

import ru.mts.display_text.domain.DisplayTextFeature
import ru.terrakok.cicerone.Router

class DisplayTextFeatureRouter(private val router: Router) : DisplayTextFeature.Output {

    override fun goToNextScreen() {
        //todo
    }

    override fun back() = router.exit()
}
