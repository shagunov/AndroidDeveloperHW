package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalculator: Button
    private lateinit var textViewResult: TextView

    private val calculatorActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val resultFromCalculator = data?.getDoubleExtra("result", 0.0)
            textViewResult.text = "Результат: $resultFromCalculator"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculator = findViewById(R.id.buttonCalculator)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculator.setOnClickListener {
            try{
                val intent = Intent(this, CalculatorActivity::class.java)
                calculatorActivityResult.launch(intent)
            }
            catch (e: Exception){
                // Create text view and set text message
                val messageView = TextView(this)
                messageView.text = "Ошибка: ${e.message}"
                // Create toast and add text view to it
                val toast = Toast.makeText(this, "", Toast.LENGTH_LONG).apply{
                    setContentView(messageView)
                }
            }
        }
    }
}
