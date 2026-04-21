package com.example.mylibraryapp.repositories

import com.example.mylibraryapp.dto.toBookOrNull
import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.network.RetrofitClient
import com.example.mylibraryapp.network.services.GoogleBooksApi

class GoogleBooksRepository(
    private val api: GoogleBooksApi = RetrofitClient.googleBooksApi
) {
    suspend fun searchBooks(query: String, maxResults: Int = 40): List<Book> {
        val response = api.searchVolumes(query = query, maxResults = maxResults)
        val items = response.items.orEmpty()
        return items.mapNotNull { it.toBookOrNull() }
    }
}