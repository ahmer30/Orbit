package com.example.orbit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbarTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        toolbarTitle = findViewById(R.id.toolbarTitle)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val btnMenu = findViewById<ImageView>(R.id.btnMenu)

        btnMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            val title = menuItem.title.toString()
            toolbarTitle.text = title
            
            when (menuItem.itemId) {
                R.id.nav_study -> replaceFragment(StudyMaterialsFragment())
                else -> replaceFragment(ComingSoonFragment())
            }
            
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Initial fragment
        if (savedInstanceState == null) {
            navView.setCheckedItem(R.id.nav_study)
            toolbarTitle.text = "Study Materials"
            replaceFragment(StudyMaterialsFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}