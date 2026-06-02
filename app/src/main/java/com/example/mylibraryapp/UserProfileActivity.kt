package com.example.mylibraryapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibraryapp.utils.SharedPreferencesManager

class UserProfileActivity : AppCompatActivity() {

    private lateinit var profileEmailTv: TextView
    private lateinit var logoutButton: ImageView

    private lateinit var sharedPrefs: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPrefs = SharedPreferencesManager(this)
        bindingViews()
        setUserEmailFromSp()
    }

    private fun bindingViews() {
        this.profileEmailTv = findViewById(R.id.user_profile_email)
        this.logoutButton = findViewById(R.id.user_profile_logout)

        this.logoutButton.setOnClickListener {
            sharedPrefs.clear()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun setUserEmailFromSp() {
        val email = sharedPrefs.getEmail()
        if(email.isEmpty()) {
            this.profileEmailTv.text = "--"
        } else {
            this.profileEmailTv.text = email
        }
    }
}