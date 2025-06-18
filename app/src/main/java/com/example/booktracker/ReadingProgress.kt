package com.example.booktracker

import java.util.Date

data class ReadingProgress(
    val progressId: Int,
    val bookId: Int,
    val pagesRead: Int,
    val percentRead: Double,
    val lastUpdate: Date,
    val startDate: Date,
    val finishDate: Date
)
