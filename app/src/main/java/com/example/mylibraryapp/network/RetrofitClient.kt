package com.example.mylibraryapp.network

import com.example.mylibraryapp.network.services.GoogleBooksApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    private const val OPEN_LIB_BASE_URL = "https://openlibrary.org"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val openLibRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(OPEN_LIB_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val googleBooksApi: GoogleBooksApi = retrofit.create(GoogleBooksApi::class.java)
}