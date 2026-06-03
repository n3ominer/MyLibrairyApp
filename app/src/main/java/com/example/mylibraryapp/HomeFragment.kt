package com.example.mylibraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Book
import com.example.mylibraryapp.models.Genre
import com.example.mylibraryapp.repositories.GoogleBooksRepository
import com.example.mylibraryapp.repositories.OpenLibraryRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeFragment : Fragment() {

    // ----------------------------------------------------------------
    // Déclaration des vues
    // ----------------------------------------------------------------
    private lateinit var booksRv: RecyclerView
    private lateinit var genreRv: RecyclerView
    private lateinit var profileUserButton: ImageView

    // ----------------------------------------------------------------
    // Déclaration des adapters
    // ----------------------------------------------------------------
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var genreAdapter: GenreAdapter

    // ----------------------------------------------------------------
    // Repositories (sources de données)
    // ----------------------------------------------------------------

    private val googleBooksRepository = GoogleBooksRepository()

    private val openLibBooksRepository = OpenLibraryRepository()







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    // STEP 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // STEP 2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews(view)
        getData()
    }



    private fun getData() {
        lifecycleScope.launch {
            try {
                //                                     Load data
                val books = openLibBooksRepository.searchBooks("bitcoin")
                setupRecyclerViews(books)
            } catch (e: Exception) {

            }
        }
    }

    // ----------------------------------------------------------------
    // Connexion Kotlin → XML (récupération des vues)
    // ----------------------------------------------------------------
    private fun bindViews(view: View) {
        booksRv = view.findViewById(R.id.home_books_recyclerView)
        genreRv = view.findViewById(R.id.home_genre_recyclerView)
        profileUserButton = view.findViewById(R.id.profile_button)
    }

    // ----------------------------------------------------------------
    // Configuration des deux RecyclerViews
    // ----------------------------------------------------------------
    private fun setupRecyclerViews(books: List<Book>) {
        val genres = books.map {
            Genre(id = it.genre.hashCode(), name = it.genre, isSelected = false)
        }.distinct()
            .sortedBy { it.name }
            .toMutableList()

        genres.add(Genre(id = 0, name = getString(R.string.genre_all), true))

        setupGenreRv(genres)   // Genres en premier (nécessaire pour le filtrage)
        setupBooksRv(books)
    }


    /*
    SharedPreferences
    {
        "email": "azeoiuazuoie@aoize.fr",
        "isLoggedIn: true,


    }
    read & write

     */
    private fun setupBooksRv(books: List<Book>) {
        // Créer l'adapter avec tous les livres
        booksAdapter = BooksAdapter(books) { selectedBook ->
            // Quand l'utilisateur clique sur un livre
            Toast.makeText(
                requireContext(),
                "📖 ${selectedBook.title}",
                Toast.LENGTH_SHORT
            ).show()
            // Exemple d'utilisation d'un pluriel :
            // resources.getQuantityString(R.plurals.book_count, books.size, books.size)
        }

        booksRv.layoutManager = LinearLayoutManager(requireContext())
        booksRv.adapter = booksAdapter
    }

    private fun setupGenreRv(genres: List<Genre>) {
        // Créer l'adapter avec tous les genres
        genreAdapter = GenreAdapter(genres) { selectedGenre ->
            // Quand l'utilisateur clique sur un chip de genre,
            // on filtre la liste des livres dans booksAdapter
            booksAdapter.filterByGenre(selectedGenre.name)
        }

        genreRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        genreRv.adapter = genreAdapter
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {}
    }
}