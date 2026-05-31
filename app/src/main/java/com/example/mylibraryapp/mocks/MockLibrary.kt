package com.example.mylibraryapp.mocks

import com.example.mylibraryapp.models.Book

object MockLibrary {

    fun getBooks(): List<Book> = listOf(
        Book(
            id = "mock-1",
            title = "1984",
            authors = "George Orwell",
            thumbnailUrl = null,
            rating = 5,
            genre = "Science-Fiction",
            description = "Roman dystopique sur un régime totalitaire où Big Brother surveille tout."
        ),
        Book(
            id = "mock-2",
            title = "Le Seigneur des Anneaux",
            authors = "J.R.R. Tolkien",
            thumbnailUrl = null,
            rating = 5,
            genre = "Fantasy",
            description = "Épopée fantasy légendaire dans le monde de la Terre du Milieu."
        ),
        Book(
            id = "mock-3",
            title = "Harry Potter à l'École des Sorciers",
            authors = "J.K. Rowling",
            thumbnailUrl = null,
            rating = 5,
            genre = "Fantasy",
            description = "Le début de l'aventure magique d'un jeune sorcier."
        ),
        Book(
            id = "mock-4",
            title = "L'Étranger",
            authors = "Albert Camus",
            thumbnailUrl = null,
            rating = 4,
            genre = "Philosophie",
            description = "Roman philosophique sur l'absurde et l'indifférence."
        ),
        Book(
            id = "mock-5",
            title = "Le Petit Prince",
            authors = "Antoine de Saint-Exupéry",
            thumbnailUrl = null,
            rating = 5,
            genre = "Roman",
            description = "Conte poétique et philosophique sur l'amitié et la vie."
        ),
        Book(
            id = "mock-6",
            title = "Dune",
            authors = "Frank Herbert",
            thumbnailUrl = null,
            rating = 5,
            genre = "Science-Fiction",
            description = "Chef-d'œuvre de la science-fiction sur une planète désertique."
        ),
        Book(
            id = "mock-7",
            title = "Les Misérables",
            authors = "Victor Hugo",
            thumbnailUrl = null,
            rating = 4,
            genre = "Roman",
            description = "Fresque sociale du XIXe siècle autour de Jean Valjean."
        ),
        Book(
            id = "mock-8",
            title = "Gone Girl",
            authors = "Gillian Flynn",
            thumbnailUrl = null,
            rating = 4,
            genre = "Thriller",
            description = "Thriller psychologique captivant sur la disparition d'Amy Dunne."
        ),
        Book(
            id = "mock-9",
            title = "Sapiens",
            authors = "Yuval Noah Harari",
            thumbnailUrl = null,
            rating = 5,
            genre = "Histoire",
            description = "Une brève histoire de l'humanité, des origines à aujourd'hui."
        ),
        Book(
            id = "mock-10",
            title = "La Vérité sur l'Affaire Harry Quebert",
            authors = "Joël Dicker",
            thumbnailUrl = null,
            rating = 4,
            genre = "Policier",
            description = "Enquête policière et roman dans le roman, best-seller mondial."
        ),
        Book(
            id = "mock-11",
            title = "Atomic Habits",
            authors = "James Clear",
            thumbnailUrl = null,
            rating = 5,
            genre = "Développement personnel",
            description = "Comment transformer sa vie grâce aux petites habitudes."
        ),
        Book(
            id = "mock-12",
            title = "Steve Jobs",
            authors = "Walter Isaacson",
            thumbnailUrl = null,
            rating = 4,
            genre = "Biographie",
            description = "La biographie autorisée du co-fondateur d'Apple."
        ),
        Book(
            id = "mock-13",
            title = "Clean Code",
            authors = "Robert C. Martin",
            thumbnailUrl = null,
            rating = 5,
            genre = "Informatique",
            description = "Les principes pour écrire un code lisible et maintenable."
        ),
        Book(
            id = "mock-14",
            title = "Le Mythe de Sisyphe",
            authors = "Albert Camus",
            thumbnailUrl = null,
            rating = 4,
            genre = "Philosophie",
            description = "Essai sur l'absurde et la révolte face à la condition humaine."
        ),
        Book(
            id = "mock-15",
            title = "Fondation",
            authors = "Isaac Asimov",
            thumbnailUrl = null,
            rating = 5,
            genre = "Science-Fiction",
            description = "La saga de la psychohistoire et de la chute d'un empire galactique."
        )
    )
}
