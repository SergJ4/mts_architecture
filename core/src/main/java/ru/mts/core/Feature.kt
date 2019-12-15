package ru.mts.core

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
interface Feature<DEPENDENCIES, OUTPUT, API> {

    val dependencies: DEPENDENCIES

    val output: OUTPUT

    val api: API
}
