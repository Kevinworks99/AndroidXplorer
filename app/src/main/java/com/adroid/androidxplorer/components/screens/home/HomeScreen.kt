package com.adroid.androidxplorer.components.screens.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.adroid.androidxplorer.R
import com.adroid.androidxplorer.components.fragments.home.AccountFragment
import com.adroid.androidxplorer.components.fragments.home.CategoryFragment
import com.adroid.androidxplorer.components.fragments.home.FavouriteFragment
import com.adroid.androidxplorer.components.fragments.home.HomeFragment
import com.adroid.androidxplorer.databinding.ActivityHomeScreenBinding
import com.adroid.androidxplorer.utils.replaceFragment

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        replaceFragment(HomeFragment())
    }

    private fun setupBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.action_favourite -> {
                    replaceFragment(FavouriteFragment())
                    true
                }

                R.id.action_category -> {
                    replaceFragment(CategoryFragment())
                    true
                }

                R.id.action_account -> {
                    replaceFragment(AccountFragment())
                    true
                }

                else -> false
            }
        }
    }
}
