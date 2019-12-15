package ru.mts.core

import ru.mts.core.base.BaseFragment
import ru.mts.core.di.Injector
import ru.mts.core.di.TagHolder
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

object FeatureManager {

    private val tagGenerator: AtomicInteger = AtomicInteger()

    private val injectors: ConcurrentHashMap<InjectorKey, Injector<*>> = ConcurrentHashMap()

    private val injectorsCounter: ConcurrentHashMap<InjectorKey, Int> = ConcurrentHashMap()

    fun <T : BaseFragment<*>> attachFragment(fragment: T) {
        val clazz = fragment.javaClass
        val tag = fragment.tag

        (injectors[InjectorKey(clazz, tag)] as? Injector<T>)?.inject(fragment)
    }

    fun <T : BaseFragment<*>> destroy(fragment: T) {
        val clazz = fragment.javaClass
        val tag = fragment.tag

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun <T : TagHolder> registerInjector(injector: Injector<T>): Int {
        val newTag = tagGenerator.incrementAndGet()
        injector.tag = newTag
        injectors[InjectorKey(injector.forClass, newTag)] = injector
        return newTag
    }

    private data class InjectorKey(
        val clazz: Class<*>,
        val tag: Int
    )
}
