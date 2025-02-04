package com.example.gridlayouttablelayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gridlayouttablelayout.databinding.ActivityGridBinding
import com.example.gridlayouttablelayout.databinding.ActivityMainBinding

class GridActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridBinding.inflate(layoutInflater)

        binding.toolBar.title = "Grid"
        setSupportActionBar(binding.toolBar)

        // set menu to toolbar
        binding.toolBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.toMainActivity -> {
                    startActivity(Intent(this, MainActivity::class.java))
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

        val view = binding.root
        setContentView(view)

        binding.one.setOnClickListener { Toast.makeText(this, "1", Toast.LENGTH_SHORT).show() }
        binding.two.setOnClickListener { Toast.makeText(this, "2", Toast.LENGTH_SHORT).show() }
        binding.three.setOnClickListener { Toast.makeText(this, "3", Toast.LENGTH_SHORT).show() }
        binding.four.setOnClickListener { Toast.makeText(this, "4", Toast.LENGTH_SHORT).show() }
        binding.five.setOnClickListener { Toast.makeText(this, "5", Toast.LENGTH_SHORT).show() }
        binding.six.setOnClickListener { Toast.makeText(this, "6", Toast.LENGTH_SHORT).show() }
        binding.seven.setOnClickListener { Toast.makeText(this, "7", Toast.LENGTH_SHORT).show() }
        binding.eight.setOnClickListener { Toast.makeText(this, "8", Toast.LENGTH_SHORT).show() }
        binding.nine.setOnClickListener { Toast.makeText(this, "9", Toast.LENGTH_SHORT).show() }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_grid_menu, menu)
        return true
    }
}