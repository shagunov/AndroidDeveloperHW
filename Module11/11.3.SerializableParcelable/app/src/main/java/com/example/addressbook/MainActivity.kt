package com.example.addressbook

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class MainActivity : AppCompatActivity(), Serializable {
    private lateinit var nameET: EditText
    private lateinit var ageET: EditText
    private lateinit var emailET: EditText
    private lateinit var sendBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)
        emailET = findViewById(R.id.emailET)
        sendBTN = findViewById(R.id.sendButton)

        sendBTN.setOnClickListener {
            val user = User(nameET.stringValue, ageET.intValue, emailET.stringValue)
            val userParcelable = UserParcelable(nameET.stringValue, ageET.intValue, emailET.stringValue)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("User", user)
            intent.putExtra("UserParcelable", userParcelable)
            startActivity(intent)
        }
    }
}

var EditText.intValue: Int
    get() = text?.toString()?.toIntOrNull() ?: 0
    set(value) = setText(value.toString())

var EditText.stringValue: String
    get() = text?.toString() ?: ""
    set(value) = setText(value)