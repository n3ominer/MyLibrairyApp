package com.example.mylibraryapp.network

import com.example.mylibraryapp.network.services.GoogleBooksApi
import com.example.mylibraryapp.network.services.OpenLIbServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://www.googleapis.com/books/v1/"


    // https://openlibrary.org/search.json?q=Android+mobile&field=*
    private const val OPEN_LIB_BASE_URL = "https://openlibrary.org/"

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val open_lib_retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(OPEN_LIB_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // GOOGLE SERVICES
    val googleBooksApi: GoogleBooksApi = retrofit.create(GoogleBooksApi::class.java)


    // OPEN LIB SERVICES
    val openLIbServices: OpenLIbServices = open_lib_retrofit.create(OpenLIbServices::class.java)
}