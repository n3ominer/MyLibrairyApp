package com.example.mylibraryapp.utils

import com.example.mylibraryapp.models.Book
import org.junit.Test
import org.junit.Assert.*

class BookFilterTest {

    // GLOBAL ARRANGE
    private fun makeBook(id: String, genre: String): Book {
        return Book(
            id = id,
            title = "Livre $id",
            authors = "Authors",
            thumbnailUrl = "",
            rating = 3,
            genre = genre,
            description = null
        )
    }

    private val books = listOf(
        makeBook("1", "Fiction"),
        makeBook("2", "Sport"),
        makeBook("33", "Sport"),
        makeBook("3", "Musique"),
        makeBook("4", "Cuisine"),
        makeBook("5", "Tech"),

    )

    @Test
    fun `Tester que filterByGenre avec le filtre tous, renvoie bien toute la liste`() {
        // ARRANGE: Deja fait avec les fonction helper

        // ACTION
        val result = BookFilter.filterByGenre(books, "Tous")

        // ASSERT
        assertEquals(result.size, books.size)
    }

    @Test
    fun `filterByGenre avec un genre existant retourne uniquement les livres de ce genre`() {
        // ARRANGE: Deja fait avec les fonction helper

        // ACTION
        val result = BookFilter.filterByGenre(books, "Sport")

        // ASSERT
        assertEquals(result.size, 2)
        assertTrue(result.all { it.genre == "Sport" })

    }

    @Test
    fun `filterByGenre avec un genre inconnu retourne une liste vide`() {
        // ARRANGE: Deja fait avec les fonction helper
        // ACTION
        val result = BookFilter.filterByGenre(books, "Dev")

        // ASSERT
        assertEquals(result.size, 0)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `filterByGenre avec liste vide retourne liste vide`() {
        // ARRANGE: Deja fait avec les fonction helper
        // ACTION
        val result = BookFilter.filterByGenre(listOf(), "Fiction")

        // ASSERT
        assertEquals(result.size, 0)
        assertTrue(result.isEmpty())
    }
}