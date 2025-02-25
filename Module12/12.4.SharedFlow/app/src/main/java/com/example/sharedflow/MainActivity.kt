package com.example.sharedflow

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val _counter = MutableSharedFlow<Int>(replay = 2, extraBufferCapacity = 5)
    val counter = _counter.asSharedFlow()

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
            for(num in 1..5){
                delay(500)
                _counter.emit(num)
            }
        }

        lifecycleScope.launch {
            counter.collect{
                Log.d("@@@Observer", "Первый подписчик получил значение: $it")
            }
        }

        lifecycleScope.launch {
            delay(1500)
            counter.collect{
                Log.d("@@@Observer", "Второй подписчик получил значение: $it")
            }
        }

        lifecycleScope.launch {
            delay(2500)
            counter.collect{
                Log.d("@@@Observer", "Третий подписчик получил значение: $it")
            }
        }
    }
}