package com.example.mylibraryapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Book

class BooksAdapter(
    private val books: List<Book>,
    private val onBookClick: (Book) -> Unit
) : RecyclerView.Adapter<BookViewHolder>() {


    // Step 1
    // Appellée à chaque fois qu'une vue doit apparaitre
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        // Création d'une Vue
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.book_cell_layout,
                parent,
                false
            )

        // Création d'un ViewHolder
        return  BookViewHolder(view) // VH n
    }

    // Step 1
    // Viewholder fraichement créé, passé pour lui mettre à jour les données
    override fun onBindViewHolder(
        holder: BookViewHolder, // VH n
        position: Int
    ) {
        val data = books[position] // Données du livre à la n-ième position

        holder.titleTextView.text = data.title
        holder.authorTextView.text = data.author

        holder.itemView.setOnClickListener { onBookClick(data) }
    }

    override fun getItemCount(): Int = books.size
}


// 1 cellule de livre
class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.book_title_textview)
    val authorTextView: TextView = itemView.findViewById(R.id.book_author_textview)
}