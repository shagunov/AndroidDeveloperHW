package com.example.fragments2.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject


@HiltViewModel
class UserEditViewModel @Inject constructor(
    private val repository: UserRepository,
    state: SavedStateHandle
): ViewModel() {

    private val id = state.get<Int>("userID") ?: -1
    private val _userDetailFlow = MutableStateFlow(User(
        name = "",
        lastName = "",
        phoneNumber = "",
        email = "",
        country = "",
        city = "",
        himself = "",
        birthDay = ""
    ))
    val userDetailFlow = _userDetailFlow.asStateFlow()

    private val _backEvent = MutableSharedFlow<Unit>()
    val backEvent = _backEvent.asSharedFlow()

    fun fetchUser(){
        _userDetailFlow.update{ repository.getUserById(id) ?: this.userDetailFlow.value }
    }

    fun submitUser(){
        if(id == -1){
            repository.addUser(_userDetailFlow.value)
        }
        else {
            repository.updateUser(id, _userDetailFlow.value)
        }
        viewModelScope.launch{ _backEvent.emit(Unit) }
    }

    fun userNameChanged(name: String) = _userDetailFlow.update { value -> value.apply { this.name = name } }
    fun userLastNameChanged(lastName: String) = _userDetailFlow.update { value -> value.apply { this.lastName = lastName } }
    fun userPhoneNumberChanged(phoneNumber: String) = _userDetailFlow.update { value -> value.apply { this.phoneNumber = phoneNumber } }
    fun userEmailChanged(email: String) = _userDetailFlow.update { value -> value.apply { this.email = email } }
    fun userCountryChanged(country: String) = _userDetailFlow.update { value -> value.apply { this.country = country } }
    fun userCityChanged(city: String) = _userDetailFlow.update { value -> value.apply { this.city = city } }
    fun userHimselfChanged(himself: String) = _userDetailFlow.update { value -> value.apply { this.himself = himself } }
    fun userDateBirthChanged(dateBirth: String) = _userDetailFlow.update { value -> value.apply { this.birthDay = dateBirth }}
}
