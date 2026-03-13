package com.example.mylibraryapp.models

/**
 * Modèle représentant un livre
 */
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val imageUrl: String,
    val rating: Float,  // Note sur 5
    val publicationDate: String,
    val genre: String,
    val description: String = ""
)