package com.example.mylibraryapp.repositories

import android.util.Log
import com.example.mylibraryapp.mocks.MockLibrary
import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.network.RetrofitClient
import com.example.mylibraryapp.network.services.OpenLIbServices
import retrofit2.HttpException
import kotlin.String

class OpenLibraryRepository (
    private val api: OpenLIbServices = RetrofitClient.openLIbServices
){

    suspend fun searchBooks(
        query: String,
        fields: String = ""
    ): List<Book> {
        return try {
            val response  = api.searchRequestWithQuery(query)
            val books: List<Book> = response.docs.map { doc ->
                Book(
                    title = doc.title,
                    authors = "Author",
                    thumbnailUrl = "",
                    rating = 3,
                    genre = "Inconnu",
                    description = doc.subtitle,
                    id = doc.key
                )
            }

            return books
        }catch (e: HttpException) {
            if (e.code() == 429) MockLibrary.getBooks()
            else throw e
        } catch (e: Exception) {
            Log.d("Exception", e.message ?: "Error")
            MockLibrary.getBooks()
        }
    }
}