package com.example.mylibraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Genre
import com.google.android.material.chip.Chip

class GenreAdapter(
    private val genres: List<Genre>
): RecyclerView.Adapter<GenreViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_genre_cell_layout, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: GenreViewHolder,
        position: Int
    ) {
        val data = genres[position]
        holder.chip.text = data.name
    }

    override fun getItemCount(): Int = genres.size

}

class GenreViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val chip: Chip = itemView.findViewById(R.id.book_genre_chip)
}