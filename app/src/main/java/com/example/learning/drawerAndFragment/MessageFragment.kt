package com.example.learning.drawerAndFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learning.R

class MessageFragment: Fragment() {
    private lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View {

        v = inflater.inflate(R.layout.fragment_message,container,false)
        return  v
    }
}