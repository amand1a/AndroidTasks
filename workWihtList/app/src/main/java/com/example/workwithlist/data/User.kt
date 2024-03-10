package com.example.workwithlist.data

import android.accounts.AuthenticatorDescription

data class User(
    val firstName: String ,
    val lastName: String,
    val age: Int,
    val sex: String ,
    val squareAvatarUri: Int,
    val description: String
)
