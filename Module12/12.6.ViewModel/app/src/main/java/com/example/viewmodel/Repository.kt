package com.example.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository {
    private val products = listOf("Морковь", "Гречка", "Сыр", "Капуста")

    fun getProducts() : Flow<String> = flow {
        for (product in products){
            delay(500)
            emit(product)
        }
    }

}