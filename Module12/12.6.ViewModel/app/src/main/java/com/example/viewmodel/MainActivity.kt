package com.example.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val mainActivityViewModel: MainActivityViewModel by viewModels()
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding!!.plusBTN) {
            setOnClickListener {
                mainActivityViewModel.incrementCounter()
            }
        }

        with(binding!!.minusBTN){
            setOnClickListener {
                mainActivityViewModel.decrementCounter()
            }
        }

        with(binding!!.nextBTN){
            setOnClickListener {
                val intent = Intent(this@MainActivity, RepositoryActivity::class.java)
                startActivity(intent)
            }
        }

        lifecycleScope.launch {
            mainActivityViewModel.counter
                .collect { binding?.counterTV?.text = it.toString() }
        }
    }
}
