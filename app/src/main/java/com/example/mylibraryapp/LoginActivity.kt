package com.example.mylibraryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    // ----------------------------------------------------------------
    // Déclaration des vues
    // ----------------------------------------------------------------
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Gérer les marges système (barre de statut, barre de navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindViews()
        setupClickListeners()
    }

    // ----------------------------------------------------------------
    // Connexion Kotlin → XML (récupération des vues)
    // ----------------------------------------------------------------
    private fun bindViews() {
        emailEditText    = findViewById(R.id.login_screen_email_editText)
        passwordEditText = findViewById(R.id.login_screen_password_editText)
        loginButton      = findViewById(R.id.login_screen_login_button)
    }

    // ----------------------------------------------------------------
    // Gestion des clics
    // ----------------------------------------------------------------
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            val email    = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validation simple : les deux champs doivent être remplis
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Connexion réussie → naviguer vers MainActivity
            Toast.makeText(this, "Bienvenue ! 👋", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Ferme LoginActivity pour ne pas y revenir avec le bouton retour
        }
    }
}