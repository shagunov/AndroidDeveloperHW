package com.example.lyfecycle

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private lateinit var bmiTextView: TextView
    private lateinit var bodyImageView: ImageView
    private lateinit var recommendationTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bmiTextView = findViewById(R.id.bmiTextView)
        bodyImageView = findViewById(R.id.bodyImageView)
        recommendationTextView = findViewById(R.id.recommendationTextView)

        val height = intent.getDoubleExtra("height", 0.0)
        val weight = intent.getDoubleExtra("weight", 0.0)

        val bmi = calculateBMI(height, weight)

        bmiTextView.text = String.format("%.2f", bmi)

        val recommendation = getRecommendation(bmi)
        recommendationTextView.text = recommendation


        // Установка картинки в зависимости от значения индекса массы тела
        if (bmi < 18.5) {
            bodyImageView.setImageResource(R.drawable.thin) // Замените `thin` на имя вашего ресурса
        } else if (bmi < 25) {
            bodyImageView.setImageResource(R.drawable.normal)  // Замените `normal` на имя вашего ресурса
        } else {
            bodyImageView.setImageResource(R.drawable.overweight) // Замените `overweight` на имя вашего ресурса
        }
    }


    private fun calculateBMI(height: Double, weight: Double): Double {
        return weight / height.pow(2)
    }



    private fun getRecommendation(bmi: Double): String {
        return when {
            bmi < 16 -> "Выраженный дефицит массы тела. Необходимо срочно обратиться к врачу!"
            bmi < 18.5 -> "Дефицит массы тела. Рекомендуется сбалансированное питание, включение в рацион высококалорийных продуктов. Возможна консультация диетолога."
            bmi < 25 -> "Нормальный вес. Продолжайте вести здоровый образ жизни."
            bmi < 30 -> "Избыточный вес. Рекомендуется пересмотреть режим питания, снизить потребление жирной и сладкой пищи, увеличить физическую активность."
            bmi < 35 -> "Ожирение 1 степени. Необходима консультация врача и разработка индивидуального плана питания и тренировок."
            bmi < 40 -> "Ожирение 2 степени. Необходима помощь специалистов."
            else -> "Ожирение 3 степени. Необходима срочная медицинская помощь."

        }
    }
}
