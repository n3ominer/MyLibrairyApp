package com.example.mylibraryapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.mocks.getBooks

class MainActivity : AppCompatActivity() {

    // Views
    private lateinit var booksRv: RecyclerView
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bindViews()
        setupRecyclerView()
    }

    private fun bindViews() {
        booksRv = findViewById(R.id.home_books_recyclerView)
    }

    private fun setupRecyclerView() {
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
}