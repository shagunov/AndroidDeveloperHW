    package com.example.androidcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

    data class Time(val hours: EditText, val minutes: EditText, val seconds: EditText){

        fun toSeconds() = hours.text.toString().toInt() * 3600 + minutes.text.toString().toInt() * 60 + seconds.text.toString().toInt()
        fun isValid() = hours.text.isNotEmpty() && minutes.text.isNotEmpty() && seconds.text.isNotEmpty()
        override fun toString() = "$hours h $minutes m $seconds s"

        fun create() {
            seconds.setOnFocusChangeListener { _, _ -> checkSeconds()
            }

            minutes.setOnFocusChangeListener { _, _ -> checkMinutes() }
        }

        fun checkMinutes(){
            if (minutes.text.isNotEmpty()) {
                if (minutes.text.toString().toInt() >= 60) {
                    hours.setText(when {
                        hours.text.isNotEmpty() -> (hours.text.toString().toInt() + minutes.text.toString().toInt() / 60).toString()
                        else -> (minutes.text.toString().toInt() / 60).toString()
                    })
                    minutes.setText((minutes.text.toString().toInt() % 60).toString())
                }
            }
        }
        fun checkSeconds(){
            if (seconds.text.isNotEmpty()) {
                if (seconds.text.toString().toInt() >= 60) {
                    minutes.setText( when {
                       minutes.text.isNotEmpty() -> (minutes.text.toString().toInt() + seconds.text.toString().toInt() / 60).toString()
                        else -> (seconds.text.toString().toInt() / 60).toString()
                    })
                    checkMinutes()
                    seconds.setText((minutes.text.toString().toInt() % 60).toString())
                }
            }
        }

        fun clear(){
            hours.setText("")
            minutes.setText("")
            seconds.setText("")
        }
    }

    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var clearButton: Button
    private lateinit var time1: Time
    private lateinit var time2: Time
    private lateinit var out: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton = findViewById(R.id.plusButton)
        minusButton = findViewById(R.id.minusButton)
        clearButton = findViewById(R.id.clearButton)
        time1 = Time(findViewById(R.id.firstNumber1), findViewById(R.id.secondNumber1), findViewById(R.id.thirdNumber1))
        time2 = Time(findViewById(R.id.firstNumber2), findViewById(R.id.secondNumber2), findViewById(R.id.thirdNumber2))
        time1.create()
        time2.create()
        out = findViewById(R.id.Out)

        plusButton.setOnClickListener { setOut { a, b -> a + b } }
        minusButton.setOnClickListener { setOut { a, b -> a - b } }
        clearButton.setOnClickListener {
            time1.clear()
            time2.clear()
            out.text = getString(R.string.InitialOut)
        }

    }

    fun setOut(operation: (Int, Int) -> Int){
        if (!time1.isValid() || !time2.isValid()) {
            out.text = "Invalid input"
            return
        }
        val second = operation(time1.toSeconds(), time2.toSeconds())
        val hours = second / 3600
        val minutes = (second % 3600) / 60
        val seconds = second % 60
        val result = "$hours h $minutes m $seconds s"
        out.text = result
    }


}