package com.example.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flowOn

class RepositoryViewModel : ViewModel() {
    private val repository = Repository()
    private val _productList = mutableListOf<String>()
    val productList: List<String> = _productList

    private val _updateNotify = MutableSharedFlow<Unit>()
    val updateNotify = _updateNotify.asSharedFlow()

    suspend fun loadProducts() {
        repository.getProducts().flowOn(Dispatchers.IO).collect{
            _productList.add(it)
            _updateNotify.emit(Unit)
        }
    }

    fun clearList(){
        _productList.clear()
    }
}