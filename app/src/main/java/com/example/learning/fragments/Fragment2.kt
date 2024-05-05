package com.example.testfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.learning.R
import com.example.learning.fragments.Communicator

class Fragment2 : Fragment() {
    private var output: String ?= ""
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment2, container, false)
        val textView: TextView = view.findViewById(R.id.textViewf2)
        output = arguments?.getString("message").toString()
        textView.text = output
        return view
    }
}