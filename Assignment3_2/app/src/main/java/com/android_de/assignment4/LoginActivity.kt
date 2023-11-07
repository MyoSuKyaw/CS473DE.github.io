package com.android_de.assignment4

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity: AppCompatActivity() {

    private lateinit var btnLogin: MaterialButton
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var btnCreateAccount: MaterialButton
    private lateinit var txtForgetPassword: TextView

    fun getUserList() = mutableListOf<User>(
        User("user", "one", "user1@gmail.com", "123"),
        User("user", "two", "user2@gmail.com", "123"),
        User("user", "three", "user3@gmail.com", "123"),
        User("user", "four", "user4@gmail.com", "123"),
        User("user", "five", "user5@gmail.com", "123")
    )

    var userFound: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

}