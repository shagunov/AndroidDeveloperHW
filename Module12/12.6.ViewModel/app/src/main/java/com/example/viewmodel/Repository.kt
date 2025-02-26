package com.example.viewmodel

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {
    private val products = listOf("Морковь", "Гречка", "Сыр", "Капуста")

    fun getProducts() : Flow<String> = flow {
        for (product in products){
            delay(2000)
            emit(product)
        }
    }

}