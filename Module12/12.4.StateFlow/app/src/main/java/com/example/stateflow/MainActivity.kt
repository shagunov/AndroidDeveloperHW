package com.example.stateflow

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            while(true){
                delay(1000L)
                _counter.value++
            }
        }

        lifecycleScope.launch {
            while(true){
                counter.collect{
                    Log.d("@@@First observer", "Счётчик: $it")
                }
            }
        }

        lifecycleScope.launch {
            while (true){
                delay(3000)
                counter.collect{
                    Log.d("@@@Second observer", "Счётчик: $it")
                }
            }
        }
    }
}