package com.example.fragments2

import android.app.Application
import com.example.fragments2.model.UserRepository

class UserListApplication: Application() {

    companion object {
        lateinit var instance: UserListApplication
    }

    val repository = UserRepository()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}