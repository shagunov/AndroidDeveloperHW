package com.example.coldandhot

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

class MainActivity : AppCompatActivity() {

    private lateinit var flowBTN: Button
    private lateinit var sharedFlowBTN: Button
    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedFlow = MutableSharedFlow<Int>(replay = 1)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        flowBTN = findViewById(R.id.flowBTN)
        sharedFlowBTN = findViewById(R.id.sharedFlowBTN)
        resultTV = findViewById(R.id.resultTV)

        fun numberFlow(): Flow<Int> = flow{
            for(num in 1..3){
                delay(1000)
                emit(num)
            }
        }

        lifecycleScope.launch {
            for(num in 1..3){
                delay(1000)
                sharedFlow.emit(num)
            }
        }

        flowBTN.setOnClickListener {
            resultTV.text = ""

            lifecycleScope.launch {
                numberFlow()
                    .onCompletion {
                        delay(3000L)
                        resultTV.text = getString(R.string.let_s_get_started)
                    }
                    .collect{ resultTV.text = "${resultTV.text} $it" }
            }
        }

        sharedFlowBTN.setOnClickListener {
            resultTV.text = ""

            lifecycleScope.launch{
                sharedFlow
                    .buffer()
                    .collect{
                        delay(2000)
                        resultTV.text = "${resultTV.text} $it"
                    }
            }
        }
    }
}
