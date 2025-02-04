package com.example.customlistview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = arrayListOf(
            User("Boris", 20, R.drawable.bur_img),
            User("Nikita", 21, R.drawable.gaga_img),
            User("Max", 22, R.drawable.lupa_img),
            User("Pavel", 23, R.drawable.pupa_img),
            User("Ivan", 24, R.drawable.rur_img))

        adapter = CustomAdapter(this, users)
        binding.listView.adapter = adapter

    }
}