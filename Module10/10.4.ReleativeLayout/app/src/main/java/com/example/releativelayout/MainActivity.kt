package com.example.releativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import com.example.releativelayout.Database.text

class MainActivity : AppCompatActivity() {

    private lateinit var textViewBook: TextView
    private lateinit var buttonLoad: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewBook = findViewById(R.id.textViewBook)
        buttonLoad = findViewById(R.id.buttonLoad)

        buttonLoad.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                loadBook(text)
            } else {
                textViewBook.text = "" // Опционально, можно сбросить текст при отключении кнопки
            }
        }
    }


    private fun loadBook(text: String) {
        val words = splitTextIntoWords(text)
        textViewBook.text = words.joinToString(" ")
    }


    private fun splitTextIntoWords(text: String): List<String> {
        return text.split("\\s+".toRegex())
    }

}