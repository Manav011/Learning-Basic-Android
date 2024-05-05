package com.example.learning.fragmentswipe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.learning.R
import com.example.learning.fragments.Fragment1
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragments = listOf(FirstFragment(), SecondFragment()) // Replace with your fragment instances
        val adapter = ViewPagerAdapter(fragments, supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

//        var bottomnav: BottomNavigationView = findViewById(R.id.tabLayout)
//        bottomnav.setOnItemSelectedListener { menuItem ->
//            when(menuItem.itemId){
//                R.id.frg1->{
//                    supportFragmentManager.beginTransaction().replace(R.id.viewPager, FirstFragment()).commit()
////                    Toast.makeText(this, "searched", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.frg2->{
//                    supportFragmentManager.beginTransaction().replace(R.id.viewPager, SecondFragment()).commit()
////                    Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else-> false
//            }
//        }

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set tab text or icon here if needed
            tab.text = "Tab ${position + 1}"
        }.attach()

    }
}