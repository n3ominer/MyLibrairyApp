package com.example.mylibraryapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibraryapp.repositories.OpenLibraryRepository
import com.google.android.material.search.SearchBar
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchPageFragment : Fragment() {

    private lateinit var searchField: EditText
    private lateinit var booksListRv: RecyclerView
    private lateinit var searchBtn: Button

    private val openLibBooksRepository = OpenLibraryRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews(view)

    }

    private fun bindViews(view: View) {
        searchField = view.findViewById(R.id.search_field)
        booksListRv = view.findViewById(R.id.search_result_list_rv)
        searchBtn = view.findViewById(R.id.search_btn)

        searchBtn.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        lifecycleScope.launch {
            try {
                //                                     Load data
                val books = openLibBooksRepository.searchBooks(searchField.text.toString())
                Log.d("SEARCH RESULT", books.size.toString())
            } catch (e: Exception) {

            }
        }
    }

}