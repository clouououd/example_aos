package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initializeLayout()
    }

    @SuppressLint("CutPasteId")
    private fun initializeLayout() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)

        val drawerLayout : DrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView : NavigationView = findViewById<NavigationView>(R.id.nav_view)

        val actionBarDrawerToggle : ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.closed)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuitem01 -> {
                    Toast.makeText(applicationContext, "SelectedItem 1", Toast.LENGTH_SHORT).show()
                }
                R.id.menuitem02 -> {
                    Toast.makeText(applicationContext, "SelectedItem 2", Toast.LENGTH_SHORT).show()
                }
                R.id.menuitem03 -> {
                    Toast.makeText(applicationContext, "SelectedItem 3", Toast.LENGTH_SHORT).show()
                }
            }
            val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    @Deprecated("Deprecated in Java") // 사용시 메시지를 보여줌
    override fun onBackPressed() {
        val drawer : DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
