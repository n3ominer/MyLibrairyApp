package com.example.mylibraryapp.repositories

import com.example.mylibraryapp.dto.toBookOrNull
import com.example.mylibraryapp.mocks.MockLibrary
import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.network.RetrofitClient
import com.example.mylibraryapp.network.services.GoogleBooksApi
import retrofit2.HttpException

class GoogleBooksRepository(
    private val api: GoogleBooksApi = RetrofitClient.googleBooksApi
) {
    /**
     * Recherche des livres via l'API Google Books.
     * Si l'API répond 429 (quota dépassé) ou toute autre erreur réseau,
     * on bascule automatiquement sur les données locales (MockLibrary).
     */
    suspend fun searchBooks(query: String, maxResults: Int = 40): List<Book> {
        return try {
            val response = api.searchVolumes(query = query, maxResults = maxResults)
            val books = response.items.orEmpty().mapNotNull { it.toBookOrNull() }
            books.ifEmpty { MockLibrary.getBooks() }
        } catch (e: HttpException) {
            if (e.code() == 429) MockLibrary.getBooks()
            else throw e
        } catch (e: Exception) {
            // Pas de réseau, timeout, etc. → fallback local
            MockLibrary.getBooks()
        }
    }
}
