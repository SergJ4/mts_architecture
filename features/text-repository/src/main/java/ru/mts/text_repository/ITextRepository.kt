package ru.mts.text_repository

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

interface ITextRepository {
    val currentText: Observable<String>

    fun setNewText(newText: String)
}
