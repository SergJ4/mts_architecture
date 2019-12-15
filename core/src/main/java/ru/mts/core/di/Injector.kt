package ru.mts.core.di

abstract class Injector<T : TagHolder>(
    val forClass: Class<T>
) : TagHolder {

    override var tag: Int = -1

    abstract fun inject(objectToInject: T)
}
