package com.example.mylibraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Book

class BooksAdapter(
    // La liste complète des livres (elle ne change jamais)
    private val books: List<Book>,
    // Callback appelé quand l'utilisateur clique sur un livre
    private val onBookClick: (Book) -> Unit
) : RecyclerView.Adapter<BookViewHolder>() {

    // Liste affichée à l'écran (peut être filtrée par genre)
    private var displayedBooks: List<Book> = books

    // ----------------------------------------------------------------
    // Étape 1 : Créer la vue d'une cellule
    // ----------------------------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_cell_layout, parent, false)
        return BookViewHolder(view)
    }

    // ----------------------------------------------------------------
    // Étape 2 : Remplir la cellule avec les données
    // ----------------------------------------------------------------
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val livre = displayedBooks[position]
        holder.bind(livre)

        // Clic sur la carte → on transmet le livre cliqué
        holder.itemView.setOnClickListener {
            onBookClick(livre)
        }
    }

    // ----------------------------------------------------------------
    // Combien d'éléments dans la liste ?
    // ----------------------------------------------------------------
    override fun getItemCount(): Int = displayedBooks.size

    // ----------------------------------------------------------------
    // Filtrer la liste par genre
    // Appelé depuis MainActivity quand l'utilisateur sélectionne un chip
    // ----------------------------------------------------------------
    fun filterByGenre(genre: String) {
        displayedBooks = if (genre == "Tous") {
            // "Tous" → on réaffiche tous les livres
            books
        } else {
            // On garde uniquement les livres dont le genre correspond
            books.filter { it.genre == genre }
        }
        // Notifier le RecyclerView que les données ont changé
        // ⚠️ notifyDataSetChanged() rafraîchit TOUTE la liste.
        // C'est la méthode la plus simple (on verra des alternatives plus tard)
        @Suppress("NotifyDataSetChanged")
        notifyDataSetChanged()
    }
}

// --------------------------------------------------------------------
// ViewHolder : représente une seule cellule de la liste
// --------------------------------------------------------------------
class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleTextView: TextView = itemView.findViewById(R.id.book_title_textview)
    val authorTextView: TextView = itemView.findViewById(R.id.book_author_textview)
    val genreTextView: TextView = itemView.findViewById(R.id.book_genre_textview)
    val ratingTextView: TextView = itemView.findViewById(R.id.book_rating_textview)

    fun bind(livre: Book) {
        titleTextView.text = livre.title
        authorTextView.text = livre.authors
        genreTextView.text = livre.genre
        ratingTextView.text = livre.rating.toString()
    }
}