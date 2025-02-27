package com.example.viewmodel2

import kotlinx.coroutines.delay

class Repository {

    private var accessCounter = 0

    suspend fun fetchData(): String {
        delay(2000)
        accessCounter++
        if (accessCounter % 3 == 0) throw Exception("Access denied")
        return "Загруженные данные"
    }
}