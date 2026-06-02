package com.example.mylibraryapp.dto.open_lib_dto

import com.google.gson.annotations.SerializedName

data class Doc(
    // author_key ==> null
    @SerializedName("author_key")
    val authorKey: List<String>,
    @SerializedName("author_name")
    val authorName: List<String>,
    @SerializedName("cover_edition_key")
    val coverEditionKey: String,
    @SerializedName("cover_i")
    val coverI: Int,
    @SerializedName("ebook_access")
    val ebookAccess: String,
    @SerializedName("edition_count")
    val editionCount: Int,
    @SerializedName("first_publish_year")
    val firstPublishYear: Int,
    @SerializedName("has_fulltext")
    val hasFulltext: Boolean,
    val ia: List<String>,
    @SerializedName("ia_collection")
    val iaCollection: List<String>,
    val key: String,
    val language: List<String>,
    @SerializedName("lending_edition_s")
    val lendingEditionS: String,
    @SerializedName("lending_identifier_s")
    val lendingIdentifierS: String,
    @SerializedName("public_scan_b")
    val publicScanB: Boolean,
    val subtitle: String,
    val title: String
)