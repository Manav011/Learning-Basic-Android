package com.example.learning.misc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.learning.R

class Custom_Toast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        val btnToast = findViewById<Button>(R.id.btnToast)

        btnToast.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.custom_toast)
            val inflater = layoutInflater

            val layout: View = inflater.inflate(R.layout.custom_toast1, vg)

            val tv = layout.findViewById<TextView>(R.id.txtVw)
            tv.text = "This is How to make Custom Toast"

            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.BOTTOM, 0, 50)
            toast.setView(layout)
            toast.duration = Toast.LENGTH_LONG
            toast.show()
        }
    }
}