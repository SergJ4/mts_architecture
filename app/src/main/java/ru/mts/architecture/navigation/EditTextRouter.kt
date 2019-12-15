package ru.mts.architecture.navigation

import ru.mts.edit_text.domain.EditTextFeature
import ru.terrakok.cicerone.Router

class EditTextRouter(private val router: Router) : EditTextFeature.Output {
    override fun back() = router.exit()
}
