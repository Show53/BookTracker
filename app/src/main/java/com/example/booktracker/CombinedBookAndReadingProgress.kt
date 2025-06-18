package com.example.booktracker
import java.io.Serializable

data class CombinedBookAndReadingProgress(
    val book: Book,
    val readingProgress: ReadingProgress
) : Serializable