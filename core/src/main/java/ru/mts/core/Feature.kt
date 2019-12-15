package ru.mts.core

import ru.mts.core.di.Injector

/**
 * Abstract feature.
 *
 * @property dependencies are needed in order feature could do its work. For example if
 * feature should display some text, than this text is its dependency
 *
 * @property output is feature connection with "outer world". It can be interface with
 * methods like "openSomeScreen()" ot any other things, that this feature cant do itself
 *
 * @property api is everything that feature could provide for its users (developers that use this feature)
 * For example it can provide Fragment, Repository or some Analytics service
 */
abstract class Feature<DEPENDENCIES, OUTPUT, API> {

    abstract val featureTag: String

    abstract val dependencies: DEPENDENCIES

    abstract val output: OUTPUT

    abstract val api: API

    abstract fun getInjectorFor(objectToInjectInto: Any): Injector<*>

    abstract fun destroy(destroyedObject: Any)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Feature<*, *, *>

        if (featureTag != other.featureTag) return false

        return true
    }

    override fun hashCode(): Int {
        return featureTag.hashCode()
    }

    override fun toString(): String {
        return "Feature(featureTag='$featureTag')"
    }
}
