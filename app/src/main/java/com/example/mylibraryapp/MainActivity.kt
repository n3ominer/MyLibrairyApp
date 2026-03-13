package com.example.mylibraryapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.mocks.getBooks
import com.example.mylibraryapp.mocks.getGenres

class MainActivity : AppCompatActivity() {

    // Views
    private lateinit var booksRv: RecyclerView
    private lateinit var genreRv: RecyclerView
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bindViews()
        setupRecyclerView()
    }

    private fun bindViews() {
        booksRv = findViewById(R.id.home_books_recyclerView)
        genreRv = findViewById(R.id.home_genre_recyclerView)
    }

    private fun setupRecyclerView() {
        setupBooksRv()
        setupGenreRv()
    }

    private fun setupBooksRv() {
        // Configurer l'adapter
        this.booksAdapter = BooksAdapter(getBooks()) { bookData ->
            // Intent vers le detail d'un livre
            // Intent(this, BookDetail::class.java
            // "Rempli" l'intent des données de `bookData`
            // On startActivity(intent)
            Toast.makeText(
                this,
                "Genre: ${bookData.genre}",
                Toast.LENGTH_LONG
            ).show()
        }

        // Définir le layout manager
        booksRv.layoutManager = LinearLayoutManager(this)

        // Assigner l'Adapter
        booksRv.adapter = this.booksAdapter

        // Liste de VH <==> data (getBooks())
    }

    private fun setupGenreRv() {
        this.genreAdapter = GenreAdapter(getGenres())
        genreRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genreRv.adapter = this.genreAdapter
    }
}