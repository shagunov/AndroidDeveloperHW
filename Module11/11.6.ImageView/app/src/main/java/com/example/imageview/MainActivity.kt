package com.example.imageview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        val adapter = ArrayAdapter.createFromResource(this, R.array.imagesStrings, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        binder.spinner.adapter = adapter

        binder.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> binder.imageView.setImageResource(R.drawable.cats_img)
                    1 -> binder.imageView.setImageResource(R.drawable.ship_img)
                    2 -> binder.imageView.setImageResource(R.drawable.nature_img)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binder.button.setOnClickListener {
            binder.spinner.setSelection((0..<binder.spinner.count).random())
        }

    }
}