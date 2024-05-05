package com.example.learning.fragmentswipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(private val fragments: List<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

        lateinit var data: List<String>

    override fun getItemCount(): Int = fragments.size

    fun setData(data: List<String>){
        this.data = data
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                fragments[0]
            }
            1 -> {
                val bundle = Bundle().apply {
                    putString("data", data[0])
                }
                fragments[1].apply {
                    arguments = bundle
                }
            }
            else -> Fragment()
        }
    }
}