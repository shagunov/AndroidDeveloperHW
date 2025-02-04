package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.customlistview.databinding.ListItemBinding

class CustomAdapter(var mCtx: Context, objects: List<User>) : ArrayAdapter<User>(mCtx, R.layout.list_item, objects){

    // Custom adapter logic here
    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables", "ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = inflater.inflate(R.layout.list_item, null)

        val imageView = view.findViewById<ImageView>(R.id.avatar)
        val textView1 = view.findViewById<TextView>(R.id.name)
        val textView2 = view.findViewById<TextView>(R.id.age)

        val user = getItem(position)
        imageView.setImageDrawable(mCtx.resources.getDrawable(user!!.avatarID))
        textView1.text = user.name
        textView2.text = user.age.toString()

        return view
    }
}