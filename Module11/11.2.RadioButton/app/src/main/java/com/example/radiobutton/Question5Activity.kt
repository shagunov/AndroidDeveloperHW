package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question5Activity : AppCompatActivity() {
    private lateinit var question5RadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question5)

        question5RadioGroup = findViewById(R.id.radioGroup5)
        question5RadioGroup.setOnCheckedChangeListener { _, checkedId ->
            var score = intent.getIntExtra("score", 0)
            when (checkedId) {
                R.id.radioButton52 -> {
                    score += 100
                }
            }
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}