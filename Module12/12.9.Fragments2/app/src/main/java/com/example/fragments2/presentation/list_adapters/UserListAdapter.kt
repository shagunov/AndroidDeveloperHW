package com.example.fragments2.presentation.list_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments2.databinding.UserListItemBinding
import com.example.fragments2.model.User
import kotlinx.coroutines.flow.StateFlow

class UserListAdapter(
    val onItemClickListener: (user: User, view: View) -> Unit = { _,_ -> },
    val onMenuInvocationListener: (user: User, view: View) -> Unit = { _,_ -> }
) : ListAdapter<User, UserViewHolder>(UsersDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder.binding){

            menuButton.setOnClickListener{
                onMenuInvocationListener(currentList[position], menuButton)
            }

            root.setOnClickListener{
                onItemClickListener(currentList[position], root)
            }

            userName.text = currentList[position].name
            userLastName.text = currentList[position].lastName
            userPhone.text = currentList[position].phoneNumber
            userEmail.text = currentList[position].email
        }
    }
}

class UserViewHolder(
    val binding: UserListItemBinding
): RecyclerView.ViewHolder(binding.root)

class UsersDiffCallback : ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}