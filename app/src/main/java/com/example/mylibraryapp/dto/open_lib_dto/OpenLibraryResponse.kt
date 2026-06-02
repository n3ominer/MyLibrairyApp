package com.example.mylibraryapp.dto.open_lib_dto

import com.google.gson.annotations.SerializedName

data class OpenLibraryResponse(
    val docs: List<Doc>,
    @SerializedName("documentation_url")
    val documentationUrl: String,
    val numFound: Int,
    val numFoundExact: Boolean,
    val num_found: Int,
    val offset: Any,
    val q: String,
    val start: Int
)