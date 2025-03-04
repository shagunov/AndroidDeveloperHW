package com.example.fragments2.model

import java.util.Date

data class User(
    var name: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var birthDay: Date,
    var country: String,
    var city: String,
    var himself: String
)
