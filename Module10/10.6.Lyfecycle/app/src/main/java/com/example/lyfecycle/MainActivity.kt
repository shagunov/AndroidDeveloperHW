package com.example.lyfecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val heightStr = heightEditText.text.toString()
            val weightStr = weightEditText.text.toString()


            if (heightStr.isBlank() || weightStr.isBlank()) {
                Toast.makeText(this, "Пожалуйста, введите рост и вес", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            try {
                val height = heightStr.toDouble() / 100 // Convert cm to meters
                val weight = weightStr.toDouble()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("height", height)
                intent.putExtra("weight", weight)
                startActivity(intent)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Пожалуйста, введите корректные числовые значения", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
