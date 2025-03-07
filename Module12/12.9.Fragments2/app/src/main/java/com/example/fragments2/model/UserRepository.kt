package com.example.fragments2.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    private val _users = mutableListOf<User>()
    private val users: List<User> = _users

    fun getUserById(id: Int) : User?{
        return _users.getOrNull(id)
    }

    fun getUsers() : Flow<User> = flow {
        for(user in users){
            emit(user)
        }
    }.flowOn(Dispatchers.IO)

    fun addUser(user: User){
        _users.add(user)
    }

    fun updateUser(id: Int, user: User){
        _users[id] = user
    }
}