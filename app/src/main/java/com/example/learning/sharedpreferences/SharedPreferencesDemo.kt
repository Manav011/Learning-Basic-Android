package com.example.learning.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.learning.R

class SharedPreferencesDemo : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var name: EditText
    private lateinit var email: EditText
    private val myPreferenceKey = "myPref"
    private val nameKey = "nameKey"
    private val emailKey = "emailKey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prferences)

        name = findViewById(R.id.sname)
        email = findViewById(R.id.semail)
        sharedPreferences = getSharedPreferences(myPreferenceKey, Context.MODE_PRIVATE)
    }

    fun save(view: View?){
        val n = name.text.toString()
        val e = email.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(nameKey, n)
        editor.putString(emailKey, e)
        editor.apply()
    }

    fun clear(view: View?){
        name.setText("")
        email.setText("")
    }

    fun get(view: View?){
        sharedPreferences = getSharedPreferences(myPreferenceKey, Context.MODE_PRIVATE)
        name.setText(sharedPreferences.getString(nameKey, ""))
        email.setText(sharedPreferences.getString(emailKey, ""))
    }
}