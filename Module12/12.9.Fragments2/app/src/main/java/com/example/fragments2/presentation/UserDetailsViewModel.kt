package com.example.fragments2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserDetailsViewModel(val id: Int, private val repository: UserRepository = UserRepository()): ViewModel() {

    private val _userDetailFlow = MutableStateFlow<User?>(null)
    val userDetailFlow = _userDetailFlow.asStateFlow()

    suspend fun fetchUser(){
        _userDetailFlow.update{ repository.getUserById(id) }
    }


}

@Suppress("UNCHECKED_CAST")
class UserDetailsViewModelFactory(private val repository: UserRepository, private val id: Int): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return UserDetailsViewModel(id, repository) as T
    }
}