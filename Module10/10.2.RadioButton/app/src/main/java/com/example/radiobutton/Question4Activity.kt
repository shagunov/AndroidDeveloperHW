package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question4Activity : AppCompatActivity() {
    private lateinit var question4RadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        question4RadioGroup = findViewById(R.id.radioGroup4)
        question4RadioGroup.setOnCheckedChangeListener { _, checkedId ->
            var score = intent.getIntExtra("score", 0)
            when (checkedId) {
                R.id.radioButton43 -> {
                    score += 100
                }
            }
            val intent = Intent(this, Question5Activity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}