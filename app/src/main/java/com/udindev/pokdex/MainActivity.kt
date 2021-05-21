package com.udindev.pokdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.udindev.pokdex.databinding.ActivityMainBinding
import com.udindev.pokdex.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
        supportFragmentManager.beginTransaction().replace(R.id.relativelayout, HomeFragment()).commit()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun displayScreen(id: Int){

//        when (id){
//            R.id.nav_beranda -> {
//                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, HomeFragment()).commit()
//            }
//
//            R.id.nav_daftar_kuliner -> {
//                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, DaftarKulinerFragment()).commit()
//            }
//
//            R.id.nav_logout -> {
//                startActivity(Intent(this,LoginActivity::class.java))
//                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, MoviesFragment()).commit()
//            }

        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}


