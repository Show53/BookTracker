package com.example.booktracker

import java.io.Serializable
import java.util.Date

data class Message(
    val id: Int,
    val bookId: Int,
    val userId: Int,
    val content: String,
    val createdAt: Date
) : Serializable
