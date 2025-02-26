package com.example.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryViewModel : ViewModel() {
    private val repository = Repository()
    val productList = mutableListOf<String>()

    fun loadProducts() : Flow<String> = flow {
        repository.getProducts().flowOn(Dispatchers.IO).collect{emit(it)}
    }
}