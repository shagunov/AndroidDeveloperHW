package com.example.fragments2.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

class UserFormState(
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val country: String,
    val city: String,
    val himself: String
)

@HiltViewModel
class UserEditViewModel @Inject constructor(
    private val repository: UserRepository,
    state: SavedStateHandle
): ViewModel() {

    private val id = state.get<Int>("UserID") ?: 0

    private val _userFormState = MutableStateFlow(UserFormState("", "", "", "", "", "", ""))
    val userFormState = _userFormState.asStateFlow()

    val fetchJob: Job = viewModelScope.launch(Dispatchers.IO){
        repository.getUserById(id)?.apply {
            _userFormState.update {
                UserFormState(
                    name = name,
                    lastName = lastName,
                    phoneNumber = phoneNumber,
                    email = email,
                    country = country,
                    city = city,
                    himself = himself
                )
            }
        }
    }

    private val _backEvent = MutableSharedFlow<Unit>()
    val backEvent = _backEvent.asSharedFlow()

    fun submitUser(){
        if(id == 0){
            viewModelScope.launch(Dispatchers.IO) {
                repository.addUser(
                    User(
                        name = userFormState.value.name,
                        lastName = userFormState.value.lastName,
                        phoneNumber = userFormState.value.phoneNumber,
                        email = userFormState.value.email,
                        country = userFormState.value.country,
                        city = userFormState.value.city,
                        himself = userFormState.value.himself
                    )
                )
            }
        }
        else {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateUser(
                    User(
                        id = id,
                        name = userFormState.value.name,
                        lastName = userFormState.value.lastName,
                        phoneNumber = userFormState.value.phoneNumber,
                        email = userFormState.value.email,
                        country = userFormState.value.country,
                        city = userFormState.value.city,
                        himself = userFormState.value.himself
                    )
                )
            }
        }
        viewModelScope.launch{ _backEvent.emit(Unit) }
    }

    fun userNameChanged(name: String) {
        _userFormState.update { UserFormState(
            name = name,
            lastName = userFormState.value.lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = userFormState.value.email,
            country = userFormState.value.country,
            city = userFormState.value.city,
            himself = userFormState.value.himself
        ) }
    }

    fun userLastNameChanged(lastName: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = userFormState.value.email,
            country = userFormState.value.country,
            city = userFormState.value.city,
            himself = userFormState.value.himself
        ) }
    }

    fun userPhoneNumberChanged(phoneNumber: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = userFormState.value.lastName,
            phoneNumber = phoneNumber,
            email = userFormState.value.email,
            country = userFormState.value.country,
            city = userFormState.value.city,
            himself = userFormState.value.himself
        ) }
    }

    fun userEmailChanged(email: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = userFormState.value.lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = email,
            country = userFormState.value.country,
            city = userFormState.value.city,
            himself = userFormState.value.himself
        ) }
    }

    fun userCountryChanged(country: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = userFormState.value.lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = userFormState.value.email,
            country = country,
            city = userFormState.value.city,
            himself = userFormState.value.himself
        ) }
    }

    fun userCityChanged(city: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = userFormState.value.lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = userFormState.value.email,
            country = userFormState.value.country,
            city = city,
            himself = userFormState.value.himself
        ) }
    }

    fun userHimselfChanged(himself: String) {
        _userFormState.update { UserFormState(
            name = userFormState.value.name,
            lastName = userFormState.value.lastName,
            phoneNumber = userFormState.value.phoneNumber,
            email = userFormState.value.email,
            country = userFormState.value.country,
            city = userFormState.value.city,
            himself = himself
        ) }
    }
}
