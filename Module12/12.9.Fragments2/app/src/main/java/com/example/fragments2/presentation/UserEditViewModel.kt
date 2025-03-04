package com.example.fragments2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date

class UserEditViewModel(val id: Int, private val repository: UserRepository = UserRepository()): ViewModel() {


    private val _userDetailFlow = MutableStateFlow<User?>(null)
    val userDetailFlow = _userDetailFlow.asStateFlow()

    suspend fun fetchUser(){
        _userDetailFlow.update{ repository.getUserById(id) }
    }

    suspend fun submitUser(){
        if(id == -1){
            repository.addUser(_userDetailFlow.value!!)
        }
        else {
            repository.updateUser(id, _userDetailFlow.value!!)
        }
    }

    fun userNameChanged(name: String) = _userDetailFlow.update { value -> value.apply { this?.name = name } }
    fun userLastNameChanged(lastName: String) = _userDetailFlow.update { value -> value.apply { this?.lastName = lastName } }
    fun userPhoneNumberChanged(phoneNumber: String) = _userDetailFlow.update { value -> value.apply { this?.phoneNumber = phoneNumber } }
    fun userEmailChanged(email: String) = _userDetailFlow.update { value -> value.apply { this?.email = email } }
    fun userCountryChanged(country: String) = _userDetailFlow.update { value -> value.apply { this?.country = country } }
    fun userCityChanged(city: String) = _userDetailFlow.update { value -> value.apply { this?.city = city } }
    fun userHimselfChanged(himself: String) = _userDetailFlow.update { value -> value.apply { this?.himself = himself } }
    fun userDateBirthChanged(dateBirth: String) = _userDetailFlow.update { value -> value.apply { this?.birthDay = Date(dateBirth) }}
}

@Suppress("UNCHECKED_CAST")
class UserEditViewModelFactory(private val repository: UserRepository, private val id: Int): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return UserEditViewModel(id, repository) as T
    }
}
