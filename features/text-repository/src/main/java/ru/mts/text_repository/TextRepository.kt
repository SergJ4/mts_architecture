package ru.mts.text_repository

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

internal class TextRepository : ITextRepository {
    private val textSubject = BehaviorSubject.create<String>().apply {
        onNext("initial string")
    }

    override val currentText: Observable<String> = textSubject.hide()

    override fun setNewText(newText: String) {
        textSubject.onNext(newText)
    }
}
