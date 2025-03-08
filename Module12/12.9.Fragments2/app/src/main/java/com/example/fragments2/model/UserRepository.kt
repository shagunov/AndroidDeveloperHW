package com.example.fragments2.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    fun getUserById(id: Int) : User?{
        return userDao.getById(id)
    }

    fun getUsers() : List<User> {
        return userDao.getAll()
    }

    fun addUser(user: User){
        userDao.insertAll(user)
    }

    fun updateUser(user: User){
        userDao.updateUser(user)
    }

    fun deleteUser(id: Int){
        userDao.delete(getUserById(id)!!)
    }
}