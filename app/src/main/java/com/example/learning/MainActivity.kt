package com.example.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learning.customviews.CustomViews
import com.example.learning.drawerAndFragment.LearningFragment
import com.example.learning.externalfilestorage.ExternalFileStorageDemo
import com.example.learning.filestorage.FileStorageDemo
import com.example.learning.misc.AlarmBroadcastManager
import com.example.learning.misc.Custom_Toast
import com.example.learning.misc.DateTimePicker
import com.example.learning.misc.Progress_bar
import com.example.learning.misc.RatingsActivity
import com.example.learning.notification.Notifications
import com.example.learning.fragments.FragmentMain
import com.example.learning.fragmentswipe.MainFragment
import com.example.learning.cardview.CardViewMain
import com.example.learning.sharedpreferences.SharedPreferencesDemo
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        this can be used for normal toolbar but we can also do the following thing
//        var headnav: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(headnav)

        var headnav: MaterialToolbar = findViewById(R.id.toolbar)
        headnav.setOnMenuItemClickListener {
            when(it.itemId){
            R.id.search->{
//                Toast.makeText(this, "search has been clicked", Toast.LENGTH_LONG).show()
                true
            }
            R.id.progressbar->{
                val progressB = Intent(this@MainActivity, Progress_bar::class.java)
                startActivity(progressB)
//                overridePendingTransition(R.anim.rotate, R.anim.rotate)
                true
            }
            R.id.rating_activity->{
                val ratings = Intent(this@MainActivity, RatingsActivity::class.java)
                startActivity(ratings)
//                overridePendingTransition(R.anim.zoomout, R.anim.zoomin)
                true
            }
            R.id.custom_toast-> {
                val customtoast = Intent(this@MainActivity, Custom_Toast::class.java)
                startActivity(customtoast)
//                overridePendingTransition(R.anim.zoomin, R.anim.zoomout)

                true
            }
            R.id.notification->{
                val Notification = Intent(this@MainActivity, Notifications::class.java)
                startActivity(Notification)
//                overridePendingTransition(R.anim.zoomin, R.anim.zoomout)
                true
            }
            R.id.alarmManager->{
                var alarmmanager = Intent(this@MainActivity, AlarmBroadcastManager::class.java)
                startActivity(alarmmanager)
//                overridePendingTransition(R.anim.zoomin, R.anim.zoomout)
                true
            }
            R.id.dateTime->{
                val dateTime = Intent(this@MainActivity, DateTimePicker::class.java)
                startActivity(dateTime)
//                overridePendingTransition(R.anim.zoomin, R.anim.zoomout)
                true
            }
            R.id.navigationdrawer->{
                val fragment1 = Intent(this@MainActivity, LearningFragment::class.java)
                startActivity(fragment1)
                true
            }
            R.id.Fragment->{
                val fragment2 = Intent(this@MainActivity, FragmentMain::class.java)
                startActivity(fragment2)
                true
            }
            R.id.sharedprefrences->{
                startActivity(Intent(this@MainActivity, SharedPreferencesDemo::class.java))
                true
            }
            R.id.customviews->{
                startActivity(Intent(this@MainActivity, CustomViews::class.java))
                true
            }
            R.id.filestoragedemo->{
                startActivity(Intent(this@MainActivity, FileStorageDemo::class.java))
                true
            }
            R.id.externalfilestorage->{
                startActivity(Intent(this@MainActivity, ExternalFileStorageDemo::class.java))
                true
            }
            R.id.fragmentswipe->{
                startActivity(Intent(this@MainActivity, MainFragment::class.java))
                true
            }
            R.id.cardview->{
                startActivity(Intent(this@MainActivity, CardViewMain::class.java))
                true
            }
            else->false
        }
        }


        var bottomnav:BottomNavigationView = findViewById(R.id.bottom_bar)
        bottomnav.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.alarmmanager->{
//                    Toast.makeText(this, "searched", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_settings->{
//                    Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.home->{
//                    Toast.makeText(this, "homed", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.exit->{
                    finish()
                    true
                }
                else-> false
            }
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.header, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            R.id.search->{
////                Toast.makeText(this, "search has been clicked", Toast.LENGTH_LONG).show()
//                true
//            }
//            R.id.settings->{
//                val progressB = Intent(this@MainActivity, Progress_bar::class.java)
//                startActivity(progressB)
//                true
//            }
//            R.id.rating_activity->{
//                val ratings = Intent(this@MainActivity, RatingsActivity::class.java)
//                startActivity(ratings)
//                true
//            }
//            R.id.custom_toast-> {
//                true
//            }
//            else->super.onOptionsItemSelected(item)
//        }
//    }
}