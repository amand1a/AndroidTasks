package com.example.workwithlist.data

import com.example.workwithlist.R

class UserService(

) {


    fun generateUsers(): ArrayList<User> {
        val users = arrayListOf<User>()

        for (i in 1..30) {
            val user = User(
                firstName = "First Name $i",
                lastName = "Last Name $i",
                age = 20 + i, // Example age calculation
                sex = if (i % 2 == 0) "Male" else "Female", // Alternate between Male and Female
                squareAvatarUri = R.drawable.ilona,
                description = getRandomString(10 + i)) // Generate description with varying number of words
            users.add(user)
        }

        return users
    }


}