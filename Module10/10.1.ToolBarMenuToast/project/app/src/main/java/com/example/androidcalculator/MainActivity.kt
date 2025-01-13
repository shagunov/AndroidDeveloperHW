    package com.example.androidcalculator

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    class EditTextWithValue(
        private val editText: EditText,
        value: Int = 0, // Current value
        private val maxValue: Int? = null, // Max value is null when hours
        private val greaterEdit: EditTextWithValue? = null // greater edit is null when this is hours
    ){
        // Value of edit text is private and can be get by toString function
        var value: Int = value
        private set

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
        fun toSeconds() = hours.value * 3600 + minutes.value * 60 + seconds.value

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
    private lateinit var toolbar: Toolbar
    private lateinit var out: TextView

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.clearMenuItem -> {
                timeForm1.clear()
                timeForm2.clear()
                out.text="00 h00 m00 s"
                Toast.makeText(
                    this,
                    "Данные очищены",
                    Toast.LENGTH_LONG).show()
                out.setTextColor(Color.parseColor("#000000"))
            }
            R.id.exitMenuItem -> {
                finish()
                Toast.makeText(
                    this,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        title = "Калькулятор"
        toolbar.setLogo(R.drawable.ic_calculator)
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
            out.setTextColor(Color.parseColor("#000000"))
        }


    }

    @SuppressLint("ResourceAsColor")
    private fun setOut(operation: (Int, Int) -> Int){
        timeForm1.synchronize()
        timeForm2.synchronize()
        val second = operation(timeForm1.toSeconds(), timeForm2.toSeconds())
        val hours = second / 3600
        val minutes = (second % 3600) / 60
        val seconds = second % 60
        val result = String.format(Locale.getDefault(), "02d h 02d m 02 s", hours, minutes, seconds)
        out.text = result
        out.setTextColor(Color.parseColor("#8B0000"))
        Toast.makeText(
            this,
            "Результат $result",
            Toast.LENGTH_LONG).show()
    }


}