package com.example.a102contextmenu

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


var EditText.value: Int?
    @SuppressLint("SetTextI18n")
    set(value) {
        if (value == null) setText("")
        else this.setText(value.toString())
    }
    get() {
        if(this.text.toString() == "") return null
        return this.text.toString().toInt()
    }

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var randomBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.NoteET)
        randomBTN = findViewById(R.id.RandomBTN)
        randomBTN.setOnClickListener {
            editText.value = (1..50).random()
        }
        registerForContextMenu(editText)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ChangeColorContextMenuItem -> {
                when{
                    editText.value == 1 || editText.value in 11..20 -> editText.setBackgroundColor(Color.rgb(255, 128, 0))
                    editText.value == 2 || editText.value in 21..30 -> editText.setBackgroundColor(Color.YELLOW)
                    editText.value == 3 || editText.value in 31..40 -> editText.setBackgroundColor(Color.GREEN)
                    editText.value == 4 || editText.value in 41..50 -> editText.setBackgroundColor(Color.BLUE)
                    editText.value == 5 -> editText.setBackgroundColor(Color.RED)

                }
            }
            R.id.ExitContextMenuItem -> finish()
        }
        return true
    }

}