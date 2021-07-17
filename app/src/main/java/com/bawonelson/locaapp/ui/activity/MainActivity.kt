package com.bawonelson.locaapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bawonelson.locaapp.R
import com.bawonelson.locaapp.databinding.ActivityMainBinding
import com.bawonelson.locaapp.databinding.ActivityMainBinding.inflate
import com.bawonelson.locaapp.ui.fragment.BagFragment
import com.bawonelson.locaapp.ui.fragment.FavoritesFragment
import com.bawonelson.locaapp.ui.fragment.ProfileFragment
import com.bawonelson.locaapp.ui.fragment.ShopFragment
import com.bawonelson.locaapp.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val shopFragment = ShopFragment()
    private val bagFragment = BagFragment()
    private val favoriteFragment = FavoritesFragment()
    private val profileFragment = ProfileFragment()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.shop -> setCurrentFragment(shopFragment)
                R.id.bag -> setCurrentFragment(bagFragment)
                R.id.favourite -> setCurrentFragment(favoriteFragment)
                R.id.profile -> setCurrentFragment(profileFragment)


            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
                .commit()
        }
}