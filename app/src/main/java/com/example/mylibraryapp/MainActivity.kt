package com.example.mylibraryapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.models.Genre
import com.example.mylibraryapp.repositories.GoogleBooksRepository
import kotlinx.coroutines.launch
import java.lang.Exception

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

    // ----------------------------------------------------------------
    // Repositories (sources de données)
    // ----------------------------------------------------------------

    private val booksRepository = GoogleBooksRepository()

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
        getData()
    }


    private fun getData() {
        lifecycleScope.launch {
            try {
              val books = booksRepository.searchBooks("bitcoin")
              setupRecyclerViews(books)
            } catch (e: Exception) {

            }
        }
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
    private fun setupRecyclerViews(books: List<Book>) {
        val genres = books.map { Genre(id = it.genre.hashCode(), name = it.genre, isSelected = false) }
            .distinct()
            .sortedBy { it.name }
            .toMutableList()

        genres.add(Genre(id = 0, name = "Tous", true))

        setupGenreRv(genres)   // Genres en premier (nécessaire pour le filtrage)
        setupBooksRv(books)
    }

    private fun setupBooksRv(books: List<Book>) {
        // Créer l'adapter avec tous les livres
        booksAdapter = BooksAdapter(books) { selectedBook ->
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

    private fun setupGenreRv(genres: List<Genre>) {
        // Créer l'adapter avec tous les genres
        genreAdapter = GenreAdapter(genres) { selectedGenre ->
            // Quand l'utilisateur clique sur un chip de genre,
            // on filtre la liste des livres dans booksAdapter
            booksAdapter.filterByGenre(selectedGenre.name)
        }

        genreRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genreRv.adapter = genreAdapter
    }
}