package com.example.learning.customviews

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learning.R

class CustomViews : AppCompatActivity() {
    lateinit var customViewFan: CustomViewFan
    lateinit var customViewDrawing: CustomViewDrawing
    lateinit var customDrawing: CustomDrawing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_views)

        val btn = findViewById<Button>(R.id.cvbtn1)
        customViewDrawing = findViewById<View>(R.id.cd) as CustomViewDrawing

        btn.setOnClickListener{
            customViewDrawing.clear()
        }

    }
}