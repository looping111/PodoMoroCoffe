package com.example.podomorocoffe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.podomorocoffe.Home.HomeFragment
import com.example.podomorocoffe.Profile.ProfileFragment
import com.example.podomorocoffe.menu.MenuFragment
import com.example.podomorocoffe.order.OrderFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)

        loadFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.navigation_menu -> {
                    loadFragment(MenuFragment())
                    true
                }

                R.id.navigation_order -> {
                    loadFragment(OrderFragment())
                    true
                }

                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false
            }

            }
        }

        private fun loadFragment(fragment: Fragment) {
            val trnasaction = supportFragmentManager.beginTransaction()
            trnasaction.replace(R.id.fragment_container, fragment)
            trnasaction.commit()

        }
}