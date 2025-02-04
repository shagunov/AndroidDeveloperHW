package com.example.saveinstancestate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        button = findViewById(R.id.button)

        savedInstanceState?.let {
            input.setText(it.getString("input"))
            output.text = it.getString("output")
        }

        button.setOnClickListener {
            output.text = input.text
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("input", output.text.toString())
        outState.putString("output", input.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        input.setText(savedInstanceState.getString("input"))
        output.text = savedInstanceState.getString("output")
    }
}