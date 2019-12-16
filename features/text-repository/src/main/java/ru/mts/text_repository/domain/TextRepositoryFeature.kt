package ru.mts.text_repository.domain

import ru.mts.core.Feature
import ru.mts.core.base.IFeature
import ru.mts.core.di.Injector
import ru.mts.text_repository.ITextRepository
import ru.mts.text_repository.TextRepository

class TextRepositoryFeature : Feature<Unit, Unit, TextRepositoryFeature.Api>() {

    override val dependencies: Unit = Unit
    override val output: Unit = Unit
    override val api: Api = object : Api {
        override fun textRepository(): ITextRepository = TextRepository()
    }

    override fun getInjectorFor(objectToInjectInto: Any): Injector<*>? = null

    override fun destroy(destroyedObject: Any) {
        // this feature does not destroy anything
    }

    interface Api : IFeature.Api {
        fun textRepository(): ITextRepository
    }
}
