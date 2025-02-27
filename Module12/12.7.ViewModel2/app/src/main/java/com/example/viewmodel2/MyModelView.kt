package com.example.viewmodel2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyModelView() : ViewModel() {
    private val repository: Repository = Repository()

    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState = _uiState.asStateFlow()

    fun fetchData() {
        viewModelScope.launch{
            _uiState.value = UiState.Loading
            try{
                val data = repository.fetchData()
                _uiState.value = UiState.Success(data)
            } catch(e: Exception) {
                _uiState.value = UiState.Error("Error: ${e.message}")
            }
        }
    }
}

sealed class UiState{
    data object Initial : UiState()
    data object Loading : UiState()
    data class Success(val result: String) : UiState()
    data class Error(val cause: String) : UiState()
}