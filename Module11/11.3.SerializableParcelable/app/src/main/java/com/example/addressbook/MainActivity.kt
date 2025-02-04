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

class MainActivity : AppCompatActivity() {
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
            val user = User(nameET.text.toString(), ageET.text.toString().toIntOrNull() ?: 0, emailET.text.toString())
            val userParcelable = UserParcelable(nameET.text.toString(), ageET.text.toString().toIntOrNull() ?: 0, emailET.text.toString())
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("User", user)
            intent.putExtra("UserParcelable", userParcelable)

            startActivity(intent)
        }
    }
}