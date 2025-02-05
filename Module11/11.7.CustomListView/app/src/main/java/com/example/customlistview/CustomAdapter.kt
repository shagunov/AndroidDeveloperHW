package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.customlistview.databinding.ListItemBinding

class CustomAdapter(var mCtx: Context, objects: List<User>) : ArrayAdapter<User>(mCtx, R.layout.list_item, objects){

    // Custom adapter logic here
    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding
        val view: View

        if (convertView == null) {
            binding = ListItemBinding.inflate(LayoutInflater.from(mCtx), parent, false)
            view = binding.root
            view.tag = binding

        } else {
            view = convertView
            binding = view.tag as ListItemBinding
        }

        val user = getItem(position)!!

        binding.avatar.setImageDrawable(ContextCompat.getDrawable(mCtx, user.avatarID))
        binding.name.text = user.name
        binding.age.text = user.age.toString()

        return view
    }
}