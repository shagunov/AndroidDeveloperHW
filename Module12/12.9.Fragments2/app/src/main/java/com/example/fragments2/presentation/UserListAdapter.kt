package com.example.fragments2.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments2.R
import com.example.fragments2.databinding.UserListItemBinding
import com.example.fragments2.model.User
import kotlinx.coroutines.flow.StateFlow

class UserListAdapter(
    private val userList: StateFlow<List<User>>,
    val onItemClickListener: (position: Int) -> Unit = {},
    val onDeleteUserEventListener: (position: Int ) -> Unit = {},
    val onEditUserEventListener: (position: Int) -> Unit = {}
): RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    class UserViewHolder(
        val binding: UserListItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.value.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder.binding){
            menuButton.setOnClickListener{
                PopupMenu(it.context, it).apply{
                    inflate(R.menu.manage_user_menu)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.deleteUser -> {
                                onDeleteUserEventListener(position)
                                true
                            }
                            R.id.editUser -> {
                                onEditUserEventListener(position)
                                true
                            }
                            else -> { false }
                        }
                    }
                }
            }

            root.setOnClickListener{
                onItemClickListener(position)
            }

            userName.text = userList.value[position].name
            userLastName.text = userList.value[position].lastName
            userPhone.text = userList.value[position].phoneNumber
            userEmail.text = userList.value[position].email
        }
    }
}
