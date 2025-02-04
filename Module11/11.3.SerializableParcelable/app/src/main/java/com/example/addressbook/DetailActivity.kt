package com.example.addressbook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val start = System.nanoTime()
        val user = intent.getSerializableExtra("User") as User
        val end = System.nanoTime()
        val userParcelable = intent.getParcelableExtra<UserParcelable>("UserParcelable")
        val endParcelable = System.nanoTime()

        val timeSerializable = end - start
        val timeParcelable = endParcelable - end

        val userInfo = "Имя: ${user.name}\nВозраст: ${user.age}\nEmail: ${user.email}"
        val userParcelableInfo = "Имя: ${userParcelable?.name}\nВозраст: ${userParcelable?.age}\nEmail: ${userParcelable?.email}"

        findViewById<TextView>(R.id.receiveTV).text = userInfo
        findViewById<TextView>(R.id.receiveParcelableTV).text = userParcelableInfo

        // Вывести диалог с результатами
        AlertDialog.Builder(this)
            .setTitle("Результаты")
            .setMessage("Время выполнения Serializable: $timeSerializable нс. Время выполнения Parcelable: $timeParcelable нс")
            .setPositiveButton("OK", null)
            .show()

        findViewById<Button>(R.id.backButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}