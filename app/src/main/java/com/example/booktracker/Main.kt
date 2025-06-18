package com.example.learning2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.booktracker.ActivityFragment
import com.example.booktracker.NullFragment
import com.example.booktracker.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_fragment, ActivityFragment())
                .commit()
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_activity -> {
                    switchToFragment("ACTIVITY_FRAGMENT", ActivityFragment())
                }
//                R.id.navigation_profile -> switchToFragment("PROFILE_FRAGMENT", ProfileFragment())
            }
            true
        }
    }

    private fun switchToFragment(tag: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val existingFragment = fragmentManager.findFragmentByTag(tag)

        if (existingFragment == null) {
            transaction.replace(R.id.nav_fragment, fragment, tag)
        } else {
            transaction.show(existingFragment)
        }

        transaction.commit()
    }
}