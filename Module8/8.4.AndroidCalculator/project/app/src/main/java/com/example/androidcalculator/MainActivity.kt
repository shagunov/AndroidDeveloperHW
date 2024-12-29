    package com.example.androidcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    class EditTextWithValue(
        private val editText: EditText,
        private var value: Int = 0, // Current value
        private val maxValue: Int? = null, // Max value is null when hours
        private val greaterEdit: EditTextWithValue? = null // greater edit is null when this is hours
    ){
        fun getValue() = value

        /**
         * function after creating view
         * */
        fun init(){
            editText.setOnFocusChangeListener { _, hasFocus ->
                if(isNotEmpty()) value = getValueFromEditText()
                if(hasFocus) {
                    clearForm()
                }
                else if (isEmpty()) {
                    setValueEditText(value)
                }
                validate() }

            setZeroValueEditText()

        }
        fun clear() = setZeroValueEditText()
        fun synchronize() {
            value = getValueFromEditText()
        }

        private fun getValueFromEditText() = editText.text.toString().toInt()
        private fun isNotEmpty() = editText.text.toString().isNotEmpty()
        private fun isEmpty() = editText.text.toString().isEmpty()
        private fun clearForm() = editText.setText("")
        private fun setZeroValueEditText(){
            editText.setText(String.format(Locale.getDefault(), "%02d", 0))
            value = 0
        }
        private fun setValueEditText(value: Int){
            editText.setText(String.format(Locale.getDefault(), "%02d", value))
            this.value = value
        }
        private fun isGreaterThenMaxValue() = maxValue != null && maxValue < value
        private fun addValueEditText(value: Int) = setValueEditText(this.value + value)
        override fun toString() = value.toString()

        private fun validate(){
            if (editText.text.toString().isNotEmpty()) {
                if (maxValue != null && isGreaterThenMaxValue()) {
                    greaterEdit?.addValueEditText(value / maxValue)
                    setValueEditText(value % maxValue)
                    greaterEdit?.validate()
                }
            }
        }

    }

    class TimeForm(hoursEdit: EditText, minutesEdit: EditText, secondsEdit: EditText){

        private val hours: EditTextWithValue = EditTextWithValue(hoursEdit)
        private val minutes: EditTextWithValue = EditTextWithValue(minutesEdit, 0, 60, hours)
        private val seconds: EditTextWithValue = EditTextWithValue(secondsEdit, 0, 60, minutes)

        // Convert time to seconds
        fun toSeconds() = hours.getValue() * 3600 + minutes.getValue() * 60 + seconds.getValue()

        override fun toString() = "$hours h $minutes m $seconds s"

        // Function for initialize time form
        fun init() {
            hours.init()
            minutes.init()
            seconds.init()
        }

        fun clear(){
            hours.clear()
            minutes.clear()
            seconds.clear()
        }

        fun synchronize(){
            hours.synchronize()
            minutes.synchronize()
            seconds.synchronize()
        }
    }

    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var clearButton: Button
    private lateinit var timeForm1: TimeForm
    private lateinit var timeForm2: TimeForm
    private lateinit var out: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
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
        timeForm1.init()
        timeForm2.init()
        out = findViewById(R.id.Out)

        plusButton.setOnClickListener { setOut { a, b -> a + b } }
        minusButton.setOnClickListener { setOut { a, b -> a - b } }
        clearButton.setOnClickListener {
            timeForm1.clear()
            timeForm2.clear()
            out.text = getString(R.string.InitialOut)
        }


    }

    private fun setOut(operation: (Int, Int) -> Int){
        timeForm1.synchronize()
        timeForm2.synchronize()
        val second = operation(timeForm1.toSeconds(), timeForm2.toSeconds())
        val hours = second / 3600
        val minutes = (second % 3600) / 60
        val seconds = second % 60
        val result = "$hours h $minutes m $seconds s"
        out.text = result
    }


}