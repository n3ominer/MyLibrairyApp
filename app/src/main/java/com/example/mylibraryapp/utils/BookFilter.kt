package com.example.mylibraryapp.utils

import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.models.Genre

object BookFilter {

    fun filterByGenre(
        books: List<Book>,
        genre: String,
        defaultLabel: String = "Tous"): List<Book> {
        return if(genre == defaultLabel) books
        else books.filter { it.genre == genre }
    }

    fun extractGenres(books: List<Book>): List<String> {
        return books.map { it.genre }.distinct().sorted()
    }
}