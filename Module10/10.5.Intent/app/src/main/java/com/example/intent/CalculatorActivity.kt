package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CalculatorActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonSendData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonSendData = findViewById(R.id.buttonSendData)

        buttonAdd.setOnClickListener { performCalculation('+') }
        buttonSubtract.setOnClickListener { performCalculation('-') }
        buttonMultiply.setOnClickListener { performCalculation('*') }
        buttonDivide.setOnClickListener { performCalculation('/') }
        buttonSendData.setOnClickListener { sendDataBack() }
    }

    private fun performCalculation(operation: Char) {
        val num1Str = editTextNumber1.text.toString()
        val num2Str = editTextNumber2.text.toString()

        if (num1Str.isBlank() || num2Str.isBlank()) {
            Toast.makeText(this, "Пожалуйста, введите числа", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            var result = 0.0

            when(operation) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "Деление на ноль!", Toast.LENGTH_SHORT).show()
                        return
                    }
                    result = num1 / num2
                }
            }
            val intent = Intent()
            intent.putExtra("result", result)
            setResult(Activity.RESULT_OK,intent)
            finish()


        } catch (e: NumberFormatException){
            Toast.makeText(this, "Некорректный формат числа", Toast.LENGTH_SHORT).show()
            return
        }

    }
    private fun sendDataBack(){
        val intent = Intent()
        setResult(Activity.RESULT_CANCELED,intent)
        finish()
    }
}
