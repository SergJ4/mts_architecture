package ru.mts.core.base

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : IFeature.Output>(
    protected val output: T
) : IBaseViewModel {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var isStarted = false

    override fun start() {
        if (!isStarted) {
            isStarted = true
            initializeViewModel()
        }
    }

    override fun back() = output.back()

    abstract fun initializeViewModel()

    protected fun <T> Observable<T>.bindToViewModel(
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {},
        onNext: (T) -> Unit
    ) {
        compositeDisposable.add(
            this.subscribe(onNext,onError, onComplete)
        )
    }
}