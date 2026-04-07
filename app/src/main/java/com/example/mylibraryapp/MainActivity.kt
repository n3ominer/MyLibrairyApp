package com.example.mylibraryapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.mocks.getBooks
import com.example.mylibraryapp.mocks.getGenres

class MainActivity : AppCompatActivity() {

    // ----------------------------------------------------------------
    // Déclaration des vues
    // ----------------------------------------------------------------
    private lateinit var booksRv: RecyclerView
    private lateinit var genreRv: RecyclerView

    // ----------------------------------------------------------------
    // Déclaration des adapters
    // ----------------------------------------------------------------
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Gérer les marges système (barre de statut, barre de navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindViews()
        setupRecyclerViews()
    }

    // ----------------------------------------------------------------
    // Connexion Kotlin → XML (récupération des vues)
    // ----------------------------------------------------------------
    private fun bindViews() {
        booksRv = findViewById(R.id.home_books_recyclerView)
        genreRv = findViewById(R.id.home_genre_recyclerView)
    }

    // ----------------------------------------------------------------
    // Configuration des deux RecyclerViews
    // ----------------------------------------------------------------
    private fun setupRecyclerViews() {
        setupGenreRv()   // Genres en premier (nécessaire pour le filtrage)
        setupBooksRv()
    }

    private fun setupBooksRv() {
        // Créer l'adapter avec tous les livres
        booksAdapter = BooksAdapter(getBooks()) { selectedBook ->
            // Quand l'utilisateur clique sur un livre
            Toast.makeText(
                this,
                "📖 ${selectedBook.title}",
                Toast.LENGTH_SHORT
            ).show()
        }

        booksRv.layoutManager = LinearLayoutManager(this)
        booksRv.adapter = booksAdapter
    }

    private fun setupGenreRv() {
        // Créer l'adapter avec tous les genres
        genreAdapter = GenreAdapter(getGenres()) { selectedGenre ->
            // Quand l'utilisateur clique sur un chip de genre,
            // on filtre la liste des livres dans booksAdapter
            booksAdapter.filterByGenre(selectedGenre.name)
        }

        genreRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genreRv.adapter = genreAdapter
    }
}