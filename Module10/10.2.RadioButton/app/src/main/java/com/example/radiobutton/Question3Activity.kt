package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question3Activity : AppCompatActivity() {
    private lateinit var question3RadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        question3RadioGroup = findViewById(R.id.radioGroup3)
        question3RadioGroup.setOnCheckedChangeListener { _, checkedId ->
            var score = intent.getIntExtra("score", 0)
            when (checkedId) {
                R.id.radioButton32 -> {
                    score += 100
                }
            }
            val intent = Intent(this, Question4Activity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}