package com.example.listview

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment(){
    private var removable: Removable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        removable = context as Removable
    }

    @SuppressLint("NewApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val user = requireArguments().getInt("id")
        val builder = AlertDialog.Builder(requireContext())
            .setMessage("Вы действительно хотите удалить пользователя?")
            .setPositiveButton("Да") { dialog, which ->
                val id = requireArguments().getInt("id")
                removable?.remove(id)
            }
            .setNegativeButton("Нет") { dialog, id ->
                // Отмена удаления
            }
        return builder.create()
    }
}