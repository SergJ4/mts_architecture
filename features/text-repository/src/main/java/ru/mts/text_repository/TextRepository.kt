package ru.mts.text_repository

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class TextRepository : ITextRepository {
    private val textSubject = BehaviorSubject.create<String>()

    override val currentText: Observable<String> = textSubject.hide()

    override fun setNewText(newText: String) {
        textSubject.onNext(newText)
    }
}
