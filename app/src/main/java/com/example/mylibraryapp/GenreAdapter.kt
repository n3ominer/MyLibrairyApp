package com.example.mylibraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.models.Genre
import com.google.android.material.chip.Chip

class GenreAdapter(
    private val genres: List<Genre>,
    // Callback appelé quand l'utilisateur sélectionne un genre
    private val onGenreSelected: (Genre) -> Unit
) : RecyclerView.Adapter<GenreViewHolder>() {

    // Index du chip actuellement sélectionné (0 = "Tous" par défaut)
    private var selectedIndex: Int = 0

    // ----------------------------------------------------------------
    // Étape 1 : Créer la vue d'un chip
    // ----------------------------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_genre_cell_layout, parent, false)
        return GenreViewHolder(view)
    }

    // ----------------------------------------------------------------
    // Étape 2 : Remplir le chip avec les données
    // ----------------------------------------------------------------
    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = genres[position]

        holder.chip.text = genre.name

        // Le chip est-il sélectionné ? On compare avec l'index courant
        holder.chip.isChecked = (position == selectedIndex)

        // Quand l'utilisateur clique sur ce chip
        holder.chip.setOnClickListener {
            // Mémoriser l'ancien index pour rafraîchir uniquement les 2 chips concernés
            val ancienIndex = selectedIndex
            selectedIndex = holder.bindingAdapterPosition

            // Rafraîchir l'ancien chip (le désélectionner visuellement)
            notifyItemChanged(ancienIndex)
            // Rafraîchir le nouveau chip (le sélectionner visuellement)
            notifyItemChanged(selectedIndex)

            // Informer MainActivity du genre sélectionné
            onGenreSelected(genre)
        }
    }

    // ----------------------------------------------------------------
    // Combien de chips ?
    // ----------------------------------------------------------------
    override fun getItemCount(): Int = genres.size
}

// --------------------------------------------------------------------
// ViewHolder : représente un seul chip de genre
// --------------------------------------------------------------------
class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val chip: Chip = itemView.findViewById(R.id.book_genre_chip)
}