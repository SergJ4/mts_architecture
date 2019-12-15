package ru.mts.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable

/**
 * Converts Observable to LiveData
 */
fun <T> Observable<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams
    .fromPublisher(
        this.toFlowable(BackpressureStrategy.LATEST)
    )