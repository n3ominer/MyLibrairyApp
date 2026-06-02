package com.example.mylibraryapp.network.services

import com.example.mylibraryapp.dto.open_lib_dto.OpenLibraryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLIbServices {

    //BASE_URL/search.json?q=Android+mobile&field=*

    @GET("search.json")
    suspend fun searchRequestWithQuery(
        @Query("q") query: String
    ): OpenLibraryResponse





    @GET("search.json")
    suspend fun searchRequestWithQueryAndFields(
        @Query("q") query: String,
        @Query("fields") fields: String,
    ): OpenLibraryResponse
}