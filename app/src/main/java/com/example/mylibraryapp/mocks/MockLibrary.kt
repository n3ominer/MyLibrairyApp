package com.example.mylibraryapp.mocks

import com.example.mylibraryapp.models.Book

/**
 * Liste de tous les livres disponibles
 */
fun getBooks(): List<Book> {
    return listOf(
        Book(
            id = 1,
            title = "1984",
            author = "George Orwell",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/71kxa1-0mfL.jpg>",
            rating = 4.7f,
            publicationDate = "1949",
            genre = "Science-Fiction",
            description = "Roman dystopique sur un régime totalitaire"
        ),
        Book(
            id = 2,
            title = "Le Seigneur des Anneaux",
            author = "J.R.R. Tolkien",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/91jBdIDK8hL.jpg>",
            rating = 4.9f,
            publicationDate = "1954",
            genre = "Fantasy",
            description = "Épopée fantasy légendaire"
        ),
        Book(
            id = 3,
            title = "Harry Potter à l'école des sorciers",
            author = "J.K. Rowling",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81YOuOGFCJL.jpg>",
            rating = 4.8f,
            publicationDate = "1997",
            genre = "Fantasy",
            description = "Le début de l'aventure magique"
        ),
        Book(
            id = 4,
            title = "L'Étranger",
            author = "Albert Camus",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/71cVq3LmqqL.jpg>",
            rating = 4.3f,
            publicationDate = "1942",
            genre = "Philosophie",
            description = "Roman philosophique sur l'absurde"
        ),
        Book(
            id = 5,
            title = "Le Petit Prince",
            author = "Antoine de Saint-Exupéry",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/71O7FmVeXrL.jpg>",
            rating = 4.6f,
            publicationDate = "1943",
            genre = "Roman",
            description = "Conte poétique et philosophique"
        ),
        Book(
            id = 6,
            title = "Dune",
            author = "Frank Herbert",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81ym3QcYwbL.jpg>",
            rating = 4.5f,
            publicationDate = "1965",
            genre = "Science-Fiction",
            description = "Chef-d'œuvre de la SF"
        ),
        Book(
            id = 7,
            title = "Les Misérables",
            author = "Victor Hugo",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/91HHxxtA1wL.jpg>",
            rating = 4.4f,
            publicationDate = "1862",
            genre = "Roman",
            description = "Fresque sociale du XIXe siècle"
        ),
        Book(
            id = 8,
            title = "Gone Girl",
            author = "Gillian Flynn",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81xqYZ8HSRL.jpg>",
            rating = 4.2f,
            publicationDate = "2012",
            genre = "Thriller",
            description = "Thriller psychologique captivant"
        ),
        Book(
            id = 9,
            title = "Sapiens",
            author = "Yuval Noah Harari",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/713jIoMO3UL.jpg>",
            rating = 4.6f,
            publicationDate = "2011",
            genre = "Histoire",
            description = "Une brève histoire de l'humanité"
        ),
        Book(
            id = 10,
            title = "La Vérité sur l'Affaire Harry Quebert",
            author = "Joël Dicker",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81ZBQS+FpyL.jpg>",
            rating = 4.5f,
            publicationDate = "2012",
            genre = "Policier",
            description = "Enquête policière passionnante"
        ),
        Book(
            id = 11,
            title = "Atomic Habits",
            author = "James Clear",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81YkqyaFVEL.jpg>",
            rating = 4.7f,
            publicationDate = "2018",
            genre = "Développement personnel",
            description = "Transformer sa vie grâce aux habitudes"
        ),
        Book(
            id = 12,
            title = "Steve Jobs",
            author = "Walter Isaacson",
            imageUrl = "<https://images-na.ssl-images-amazon.com/images/I/81VStYnDGrL.jpg>",
            rating = 4.5f,
            publicationDate = "2011",
            genre = "Biographie",
            description = "La biographie autorisée"
        )
    )
}