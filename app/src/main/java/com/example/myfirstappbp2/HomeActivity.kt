package com.example.myfirstappbp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // 1. Muat Fragment default (Dashboard) saat pertama kali dibuka
        loadFragment(DashboardFragment())

        // 2. Tambahkan listener untuk menangani klik item navigasi
        bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    fragment = DashboardFragment()
                    loadFragment(fragment)
                    true // Mengembalikan true menandakan item telah ditangani
                }
                R.id.nav_profile -> {
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_settings -> {
                    fragment = SettingsFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    // 3. Buat fungsi helper untuk memuat Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment)
            .commit()
    }
}