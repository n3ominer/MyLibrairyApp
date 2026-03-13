package com.example.mylibraryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    // Pour le moment, pas de valeur, mais il en aura une avant
    // d'être utilisé
    // Déclare nos vues
    lateinit var appLogoImageView: ImageView
    lateinit var appTitleTextView: TextView
    lateinit var emailTextInput: TextInputEditText
    lateinit var passwordTextInput: TextInputEditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Binding (connexion kotlin -> XML)

        bindViews()

        setupClickListeners()
    }

    private fun bindViews() {
        appLogoImageView = findViewById(R.id.login_screen_logo_imageView)
        appTitleTextView = findViewById(R.id.login_screen_title_textView)
        emailTextInput = findViewById(R.id.login_screen_email_editText)
        passwordTextInput = findViewById(R.id.login_screen_password_editText)
        loginButton = findViewById(R.id.login_screen_login_button)
    }

    private fun setupClickListeners() {
        // Navigate to HomeScreen
        loginButton.setOnClickListener {
            // Que faire quand ce boutton est cliqué
            // Naviguer vers un autre écran == creation d'un Intent
            Toast.makeText(this, "Login done", Toast.LENGTH_LONG).show()

            // Intent creation             START               DESTINATION
            val intent = Intent(this, MainActivity::class.java)
            // Ajouter des informations dans l'intent
            // exemple: userId
            startActivity(intent)
            finish()
        }
    }
}