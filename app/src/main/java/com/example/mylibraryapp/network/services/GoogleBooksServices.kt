package com.example.mylibraryapp.network.services

import com.example.mylibraryapp.dto.VolumesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {

    // BASE URL: https://www.googleapis.com/books/v1/
    // PATH: volumes
    // QUERY PARAMETERS:
    // https://www.googleapis.com/books/v1/volumes?q=harry+potter&maxResults=20&printType=books
    @GET("volumes")
    suspend fun searchVolumes(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 20,
        @Query("printType") printType: String = "books"
    ): VolumesResponseDto
}