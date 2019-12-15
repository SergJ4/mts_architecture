package ru.sergjav.core

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface SchedulersProvider {

    fun waiting(): Scheduler

    fun computation(): Scheduler

    fun ui(): Scheduler
}

object CommonSchedulerProvider : SchedulersProvider {
    override fun waiting(): Scheduler = Schedulers.io()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}
