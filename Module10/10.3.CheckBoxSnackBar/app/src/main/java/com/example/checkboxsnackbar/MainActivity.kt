package com.example.checkboxsnackbar

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var checkBox: CheckBox
    private lateinit var storeBTN: Button
    private lateinit var clearBTN: Button
    private lateinit var inputET: EditText
    private lateinit var outputTV: TextView
    private lateinit var checkBoxTV: TextView
    private lateinit var pddTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = findViewById(R.id.infoCB)
        storeBTN = findViewById(R.id.storeBTN)
        clearBTN = findViewById(R.id.clearBTN)
        inputET = findViewById(R.id.inputET)
        outputTV = findViewById(R.id.outputTV)
        checkBoxTV = findViewById(R.id.checkBoxTV)
        pddTV = findViewById(R.id.pddTV)

        storeBTN.setOnClickListener {
            val input = inputET.text.toString()
            outputTV.text = input
        }

        clearBTN.setOnClickListener {

            Snackbar.make(it, "Подтвердить удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить") {
                    inputET.text.clear()
                    outputTV.text = ""
                    Snackbar.make(it, "Данные удалены", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxTV.text = "Правила дорожного движения"
                pddTV.text = """«Пешеходная дорожка» — обустроенная или приспособленная для движе-
                ния пешеходов полоса земли либо поверхность искусственного сооружения,
                обозначенная знаком 4.5.1.
                Пункт 9.9 Правил запрещает движение транспортных средств по пеше-
                ходным дорожкам, допуская въезд на них лишь в исключительных случаях.
                «Пешеходная зона» — территория, предназначенная для движе-
                ния пешеходов, начало и конец которой обозначены соответственно
                знаками 5.33 и 5.34.""""
            } else {
                checkBoxTV.text = "Информация"
                pddTV.text = ""
            }
        }


    }
}