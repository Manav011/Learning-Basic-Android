package com.example.learning.misc

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learning.R

class RatingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratings)

        val btn1: Button = findViewById(R.id.submit_rating)
        val ratingtext: TextView = findViewById(R.id.rating_text)
        val ratingbar: RatingBar = findViewById(R.id.ratingbar)

        btn1.setOnClickListener() {
            var currR = ratingbar.rating
            var ratingToast = "a raing of :- $currR"
            when(currR.toInt()){
                5 -> {
                    ratingtext.setText("Damn that was goooooooooood")
                }
                4 -> {
                    ratingtext.setText("Good")
                }
                3 -> {
                    ratingtext.setText("Not Bad")
                }
                2 -> {
                    ratingtext.setText("Needs Improvement")
                }
                1 -> {
                    ratingtext.setText("Seriously")
                }
                else -> {
                    ratingtext.setText("Invalid Rating")
                }
            }
            Toast.makeText(this, ratingToast, Toast.LENGTH_SHORT).show()
        }


    }
}