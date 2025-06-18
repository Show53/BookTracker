package com.example.booktracker

import Status
import java.io.Serializable

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val pageCount: Int,
    val coverUri:String,
    val genre: String,
    val description: String,
    val status: Status,
    val rating: Double,
    val isbn: String,
    val writeDate: String
)  : Serializable
