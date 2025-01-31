package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question2Activity : AppCompatActivity() {
    private lateinit var question2RadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        question2RadioGroup = findViewById(R.id.radioGroup2)
        question2RadioGroup.setOnCheckedChangeListener { _, checkedId ->
            var score = intent.getIntExtra("score", 0)
            when (checkedId) {
                R.id.radioButton22 -> {
                    score += 100
                }
            }
            val intent = Intent(this, Question3Activity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}