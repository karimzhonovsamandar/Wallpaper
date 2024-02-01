package com.sammy.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sammy.wallpaper.databinding.ActivityMainBinding
import com.sammy.wallpaper.fragments.AllFragment
import com.sammy.wallpaper.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barIconImageView.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.START)

        }

        val bottomNavView = binding.bottomNavigationView
        val navigationView = findNavController(R.id.fragment_container)

        bottomNavView.setupWithNavController(navigationView)

   /*     navigationView.addOnDestinationChangedListener { _, destination, _ ->
            // Выполните действия при изменении фрагмента (при возврате на фрагмент)
            when (destination.id) {
                R.id.home -> {
                    // Действия для вашего фрагмента
                    // Например, обновление данных
                    val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                    if (fragment is HomeFragment) {
                        fragment.onResume() // Или другие действия
                    }
                }
                // Добавьте другие фрагменты, если необходимо
            }
        }*/

    }
}