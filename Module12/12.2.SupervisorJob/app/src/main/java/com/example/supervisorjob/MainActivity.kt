package com.example.supervisorjob

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() + CoroutineExceptionHandler{ _, cause ->
        Log.e("error", "Произошла ошибка: ${cause.message}")
    })
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.BTN)
        textView = findViewById(R.id.TV)

        button.setOnClickListener {

            lifecycleScope.launch{

                textView.text = "Запущено"
                val job1 = coroutineScope.launch {
                    delay(2000)
                    Log.d(null, "Первая корутина завершилась")
                }
                val job2 = coroutineScope.launch {
                    try {
                        delay(1000)
                        throw IllegalStateException()
                    } catch (e: Exception) {
                        Log.e(null, "Во второй корутине произошла ошибка: ${e.message}")
                        throw e
                    } finally {
                        Log.d(null, "Вторая корутина завершилась")
                    }
                }
                val job3 = coroutineScope.launch {
                    delay(3000)
                    Log.d(null, "Третья корутина завершилась")
                }
                job1.join()
                job2.join()
                job3.join()
                textView.text = "Завершено"
            }
        }

    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}