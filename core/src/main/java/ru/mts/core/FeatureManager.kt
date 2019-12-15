package ru.mts.core

import ru.mts.core.base.BaseFragment
import ru.mts.core.di.Injector
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

object FeatureManager {

    private val tagGenerator: AtomicInteger = AtomicInteger()

    private val features: ConcurrentHashMap<String, Feature<*, *, *>> = ConcurrentHashMap()

    fun <T : BaseFragment<*>> attachFragment(fragment: T) {
        val tag = fragment.featureTag

        (features[tag]
            ?.getInjectorFor(fragment) as? Injector<T>)
            ?.inject(fragment)
    }

    fun <T : BaseFragment<*>> destroy(fragment: T) {
        val tag = fragment.featureTag

        features[tag]?.destroy(fragment)
    }

    fun getTag(): Int = tagGenerator.incrementAndGet()

    fun register(feature: Feature<*, *, *>) {
        features[feature.featureTag] = feature
    }

    fun remove(feature: Feature<*, *, *>) {
        features.remove(feature.featureTag)
    }
}
