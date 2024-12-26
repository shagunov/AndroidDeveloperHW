    package com.example.androidcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment

    class MainActivity : AppCompatActivity() {

    data class TimeForm(val hours: EditText, val minutes: EditText, val seconds: EditText){

        private var curHours = 0
        private var curMinutes = 0
        private var curSeconds = 0

        fun toSeconds() = hours.text.toString().toInt() * 3600 + minutes.text.toString().toInt() * 60 + seconds.text.toString().toInt()
        fun isValid() = hours.text.isNotEmpty() && minutes.text.isNotEmpty() && seconds.text.isNotEmpty()
        override fun toString() = "$hours h $minutes m $seconds s"

        fun create() {
            seconds.setOnFocusChangeListener { _, hasFocus ->
                if(seconds.text.toString().isNotEmpty()) curSeconds = seconds.text.toString().toInt()
                if(hasFocus) {
                    seconds.setText("")
                }
                else if (seconds.text.toString() == "") {
                    seconds.setText(curSeconds.toString())
                }
                checkSeconds() }

            minutes.setOnFocusChangeListener { _, hasFocus ->
                if(minutes.text.toString().isNotEmpty()) curMinutes = minutes.text.toString().toInt()
                if(hasFocus) {
                    minutes.setText("")
                }
                else if (minutes.text.toString() == "") {
                    minutes.setText(curMinutes.toString())
                }
                checkMinutes() }

            hours.setOnFocusChangeListener { _, hasFocus ->
                if(hours.text.toString().isNotEmpty()) curHours = hours.text.toString().toInt()
                if(hasFocus) hours.setText("")
                else if (hours.text.toString() == "") {
                    hours.setText(curHours.toString())
                }}

            seconds.setText("0")
            minutes.setText("0")
            hours.setText("0")
        }

        private fun checkMinutes(){
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
        private fun checkSeconds(){
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
    private lateinit var timeForm1: TimeForm
    private lateinit var timeForm2: TimeForm
    private lateinit var out: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        try{
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            plusButton = findViewById(R.id.plusButton)
            minusButton = findViewById(R.id.minusButton)
            clearButton = findViewById(R.id.clearButton)
            timeForm1 = TimeForm(
                findViewById(R.id.firstNumber1),
                findViewById(R.id.secondNumber1),
                findViewById(R.id.thirdNumber1)
            )
            timeForm2 = TimeForm(
                findViewById(R.id.firstNumber2),
                findViewById(R.id.secondNumber2),
                findViewById(R.id.thirdNumber2)
            )
            timeForm1.create()
            timeForm2.create()
            out = findViewById(R.id.Out)

            plusButton.setOnClickListener { setOut { a, b -> a + b } }
            minusButton.setOnClickListener { setOut { a, b -> a - b } }
            clearButton.setOnClickListener {
                timeForm1.clear()
                timeForm2.clear()
                out.text = getString(R.string.InitialOut)
            }
        }
        catch(e: Exception){
            // TODO make stackTrace throw \n
            var stackInfo = ""
            for(element in e.stackTrace){
                stackInfo += element.toString() + "\n"
            }

            // TODO out error message on dialog
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Произошла ошибка: ${e.message}\n ${stackInfo}")
                .setPositiveButton("OK") { dialog, which ->
                    // Действие по нажатию на кнопку OK
                    dialog.dismiss()
                }
                .show()
        }

    }

    fun setOut(operation: (Int, Int) -> Int){
        if (!timeForm1.isValid() || !timeForm2.isValid()) {
            out.text = "Invalid input"
            return
        }
        val second = operation(timeForm1.toSeconds(), timeForm2.toSeconds())
        val hours = second / 3600
        val minutes = (second % 3600) / 60
        val seconds = second % 60
        val result = "$hours h $minutes m $seconds s"
        out.text = result
    }


}