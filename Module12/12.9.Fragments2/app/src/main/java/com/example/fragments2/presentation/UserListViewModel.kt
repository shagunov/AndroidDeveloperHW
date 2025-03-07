package com.example.fragments2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _userList = MutableStateFlow(emptyList<User>())
    val userList = _userList.asStateFlow()

    private val _navigationEvent = MutableStateFlow<UserListNavEvent?>(null)
    val navigationEvent = _navigationEvent.asStateFlow()

    suspend fun fetchData(){
        _userList.update { emptyList() }
        repository.getUsers().collect{ user -> _userList.update { value -> value + user }}
    }

    fun deleteUser(position: Int) {
    }

    fun editUser(position: Int) {
        _navigationEvent.tryEmit(UserListNavEvent.EditUser(position))
    }

    fun seeUserDetails(position: Int) {
        _navigationEvent.tryEmit(UserListNavEvent.UserDetails(position))
    }

    fun addUser() {
        _navigationEvent.tryEmit(UserListNavEvent.NewUser)
    }

    fun completeNavigation(){
        _navigationEvent.tryEmit(null)
    }
}

sealed class UserListNavEvent {
    data class EditUser(val position: Int): UserListNavEvent()
    data object NewUser: UserListNavEvent()
    data class UserDetails(val position: Int): UserListNavEvent()
}