package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question1Activity : AppCompatActivity() {
    private lateinit var question1RadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        question1RadioGroup = findViewById(R.id.radioGroup1)
        question1RadioGroup.setOnCheckedChangeListener { _, checkedId ->
            var score = 0
            when (checkedId) {
                R.id.radioButton13 -> {
                    score += 100
                }
            }
            val intent = Intent(this, Question2Activity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}