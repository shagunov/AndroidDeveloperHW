package com.example.fragments2.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository {
    private val _users = mutableListOf<User>()
    private val users: List<User> = _users

    suspend fun getUserById(id: Int) : User?{
        return _users.getOrNull(id)
    }

    suspend fun getUsers() : Flow<User> = flow {
        for(user in users){
            emit(user)
        }
    }.flowOn(Dispatchers.IO)

    suspend fun addUser(user: User){
        _users.add(user)
    }

    suspend fun updateUser(id: Int, user: User){
        _users[id] = user
    }
}