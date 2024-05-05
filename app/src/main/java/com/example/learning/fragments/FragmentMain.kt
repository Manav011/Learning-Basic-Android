package com.example.learning.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.learning.R
import androidx.fragment.app.FragmentManager
import com.example.learning.databinding.ActivityFragmentMainBinding
import com.example.testfragment.Fragment2

class FragmentMain : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityFragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fragment_main)

        binding = ActivityFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.frbtn1.setOnClickListener {
        supportFragmentManager.beginTransaction().replace(R.id.fc   , Fragment1()).commit()
//            replaceFragment(Fragment1())
        }
//        binding.frbtn2.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.fc, Fragment2()).commit()
////            replaceFragment(Fragment2())
//        }
    }

//    private fun replaceFragment(obj: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fc,obj)
//        fragmentTransaction.commit()
//
//    }

    override fun passData(editTextArgs: String){
        val bundle = Bundle()
        bundle.putString("message", editTextArgs)
        val fragment2 = Fragment2()
        fragment2.arguments = bundle
        this.supportFragmentManager.beginTransaction().replace(R.id.fc, fragment2).commit()
    }
}