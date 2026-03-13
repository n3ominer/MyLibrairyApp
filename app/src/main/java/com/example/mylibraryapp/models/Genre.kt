package com.example.mylibraryapp.models

/**
 * Modèle représentant un genre de livre (pour les filtres)
 */
data class Genre(
    val id: Int,
    val name: String,
    var isSelected: Boolean = false
)