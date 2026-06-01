package com.example.mylibraryapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesManager(context: Context) {
    companion object {
        // Static
        const val PREF_NAME = "shared_preferences_my_library"
        const val EMAIL_SP = "email"
        const val REMEMBER_ME_SP = "remember"
        const val IS_LOGGED_IN_SP = "logged_in"
    }

    /*
    {}
     */
    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )


    // Sauvegarde des données
    /*
    { "email" : "test@gmail.com"}
     */
    fun saveUserEmail(email: String){
        sharedPrefs.edit { putString(EMAIL_SP, email) }
    }

    /*
    { "email" : "test@gmail.com", "remember": true}
     */
    fun saveRememberMe(remember: Boolean) {
        sharedPrefs.edit { putBoolean(REMEMBER_ME_SP, remember) }
    }

    /*
    { "email" : "test@gmail.com", "remember": true, "logged_in": true }
     */
    fun saveIsLoggedIn(isLoggedIn: Boolean) {
        sharedPrefs.edit { putBoolean(IS_LOGGED_IN_SP, isLoggedIn) }
    }

    // Lecture dans le SP
    /*
    { "email" : "test@gmail.com", "remember": true, "logged_in": true }
    */
    fun getEmail(): String {
        // p0 --> Clé à laquelle on a associé une valeur dans les SP
        // p1 --> Valeur par défaut si aucune valeur n'a été associée à p0
        // "test@gmail.com"
        return sharedPrefs.getString(EMAIL_SP, "") ?: ""
    }

    fun isLoggedIn() : Boolean {
        return sharedPrefs.getBoolean(IS_LOGGED_IN_SP, false)
    }

    fun rememberMe(): Boolean {
        return sharedPrefs.getBoolean(REMEMBER_ME_SP, false)
    }

    // Suppression des SP
    /*
    {}
     */
    fun clear() {
        sharedPrefs.edit { clear() }
    }
}