package com.example.gridlayouttablelayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gridlayouttablelayout.databinding.ActivityTableBinding

class TableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolBar.title = "Table"
        setSupportActionBar(binding.toolBar)

        // set menu item listener
        binding.toolBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.toMainActivity -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.toGridLayout -> {
                    startActivity(Intent(this, GridActivity::class.java))
                    true
                }
                R.id.exit -> {
                    finish()
                    true
                }
                else -> {
                    finish()
                    true
                }
            }
        }

        binding.button1.setOnClickListener {
            binding.textView1.text = binding.editText.text
        }
        binding.button2.setOnClickListener {
            binding.textView2.text = binding.editText.text
        }
        binding.button3.setOnClickListener {
            binding.textView3.text = binding.editText.text
        }

        binding.addRowButton.setOnClickListener {
            val newRow = TableRow(this)
            newRow.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
            val newId = binding.tableLayout.childCount + 1
            val newRowString = "$newId строка"

            val newTextView = TextView(this).apply{
                text = newRowString
                textSize = 16f
            }

            val newButton = Button(this).apply{
                text = getText(R.string.applyString)
                textSize = 16f
                setOnClickListener {
                    val newText = binding.editText.text.toString()
                    newTextView.text = newText
                }
            }

            newRow.addView(newButton)
            newRow.addView(newTextView)
            binding.tableLayout.addView(newRow)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_table_menu, menu)
        return true
    }

}