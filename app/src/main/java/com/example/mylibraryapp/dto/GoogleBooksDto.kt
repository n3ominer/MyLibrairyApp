package com.example.mylibraryapp.dto

import com.example.mylibraryapp.models.Book
import com.google.gson.annotations.SerializedName

data class VolumesResponseDto(
    @SerializedName("items") val items: List<VolumeItemDto>?
)

data class VolumeItemDto(
    @SerializedName("id") val id: String?,
    @SerializedName("volumeInfo")val volumeInfo: VolumeInfoDto?
)

data class VolumeInfoDto(
    @SerializedName("title") val title: String?,
    @SerializedName("authors") val authors: List<String>?,
    @SerializedName("description") val description: String?,
    @SerializedName("publishedDate") val publishedDate: String?,
    @SerializedName("pageCount") val pageCount: Int?,
    @SerializedName("imageLinks") val imageLinks: ImageLinksDto?,
    @SerializedName("categories") val categories: List<String>?,
    @SerializedName("averageRating") val averageRating: Int?
)

data class ImageLinksDto(
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("smallThumbnail") val smallThumbnail: String?
)


fun VolumeItemDto.toBookOrNull(): Book? {
    val volume = volumeInfo ?: return null
    val safeId = id ?: return null

    val title = volume.title?.trim().orEmpty()
    if (title.isBlank()) return null

    val authors = volume.authors?.joinToString(separator = ", ").orEmpty().ifBlank { "Inconnu" }

    // Certains thumbnails sont en http : on force https pour éviter des blocages / mixed content
    val thumb = (volume.imageLinks?.thumbnail ?: volume.imageLinks?.smallThumbnail)
        ?.replace("http://", "https://")

    return Book(
        id = safeId,
        title = title,
        authors = authors,
        description = volume.description,
        thumbnailUrl = thumb,
        genre = volume.categories?.firstOrNull() ?: "Unknown",
        rating = volume.averageRating ?: 3
    )
}