package com.example.gridlayouttablelayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gridlayouttablelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolBar.title = "Main"
        setSupportActionBar(binding.toolBar)

        // set menu to toolbar
        binding.toolBar.inflateMenu(R.menu.activity_main_menu)

        // set menu item click listener
        binding.toolBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.toGridLayout -> {
                    startActivity(Intent(this, GridActivity::class.java))
                    true
                }
                R.id.toTableLayout -> {
                    startActivity(Intent(this, TableActivity::class.java))
                    true
                }
                R.id.exit -> {
                    finish()
                    true
                }
                else -> {
                    finish()
                    true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }
}