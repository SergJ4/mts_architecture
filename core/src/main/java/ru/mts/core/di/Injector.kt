package ru.mts.core.di

abstract class Injector<T>(val forClass: Class<T>) {

    abstract fun inject(objectToInject: T)
}
