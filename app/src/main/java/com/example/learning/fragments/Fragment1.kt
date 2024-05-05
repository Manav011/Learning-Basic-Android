package com.example.learning.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.learning.R

class Fragment1 :Fragment() {
    private lateinit var communicator: Communicator;
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment1, container, false)
        val btn: Button = view.findViewById(R.id.buttonf1)
        val editText: EditText = view.findViewById(R.id.editTextf1);
        communicator = activity as Communicator
        btn.setOnClickListener {
            communicator.passData(editText.text.toString())
        }
        return view
    }

}