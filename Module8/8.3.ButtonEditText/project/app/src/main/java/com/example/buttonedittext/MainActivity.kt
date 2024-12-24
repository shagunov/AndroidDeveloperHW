package com.example.buttonedittext

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputEdit: EditText
    private lateinit var pushButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var numberOfSymbolsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEdit = findViewById(R.id.editText)
        pushButton = findViewById(R.id.button)
        resultTextView = findViewById(R.id.resultView)
        numberOfSymbolsTextView = findViewById(R.id.numberCharsView)
        onClick(pushButton)
    }

    fun onClick(view: View){
        val reversedText = "Результат: ${inputEdit.text.reversed()}"
        resultTextView.text = reversedText

        val numberSymbols = "Количество символов: ${inputEdit.text.filterNot{it == ' '}.length}"
        numberOfSymbolsTextView.text = numberSymbols
    }
}