package com.rafaelmardom.pruebarss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rafaelmardom.pruebarss.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupNavigation()
    }

    fun setupBinding(){
        binding =ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    fun setupNavigation(){
        findViewById<BottomNavigationView>(
            R.id.bottom_navigation
        ).setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_to_feed -> navigateToFeed()
                R.id.menu_to_management -> navigateToManagement()
                R.id.menu_to_profile -> navigateToProfile()
            }
            true
        }

    }

    fun navigateToFeed(){
        findNavController(
            R.id.main_fragment_container
        ).navigate(
            NavGraphDirections.toFeed()
        )
    }

    fun navigateToManagement(){
        findNavController(
            R.id.main_fragment_container
        ).navigate(
            NavGraphDirections.toManagement()
        )
    }

    fun navigateToProfile(){
        findNavController(
            R.id.main_fragment_container
        ).navigate(
            NavGraphDirections.toProfile()
        )
    }
}