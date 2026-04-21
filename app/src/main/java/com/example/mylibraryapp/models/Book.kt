package com.example.mylibraryapp.models

/**
 * Modèle représentant un livre
 */
data class Book(
    val id: String,
    val title: String,
    val authors: String,
    val thumbnailUrl: String?,
    val rating: Int,
    val genre: String,
    val description: String?
)