package com.example.listview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity(), Removable {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var userListView: ListView
    private lateinit var userList: MutableList<User>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        saveButton = findViewById(R.id.saveButton)
        userListView = findViewById(R.id.userListView)

        userList = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getUserNames())
        userListView.adapter = adapter

        saveButton.setOnClickListener {
            saveUser()
        }

        userListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialog = MyDialog()
                val bundle = Bundle()
                bundle.putInt("id", position)
                dialog.arguments = bundle
                dialog.show(supportFragmentManager, "dialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun saveUser() {
        val name = nameEditText.text.toString().trim()
        val ageString = ageEditText.text.toString().trim()
        if(name.isEmpty() || ageString.isEmpty()){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
            return
        }
        val age = ageString.toIntOrNull()
        if(age==null){
            Toast.makeText(this, "Некорректный возраст!", Toast.LENGTH_SHORT).show();
            return;
        }

        val user = User(name, age)
        userList.add(user)
        updateListView()
        clearInputFields()
    }

    private fun removeUser(position: Int) {
        userList.removeAt(position)
        updateListView()
    }

    private fun getUserNames(): MutableList<String> {
        return userList.map { "${it.name}, ${it.age} лет" }.toMutableList()
    }

    private fun updateListView() {
        adapter.clear()
        adapter.addAll(getUserNames())
        adapter.notifyDataSetChanged()
    }

    private fun clearInputFields() {
        nameEditText.text.clear()
        ageEditText.text.clear()
    }

    override fun remove(id: Int) {
        removeUser(id)
    }
}
