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

        btnLogin = findViewById(R.id.btnLogin)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin.setOnClickListener {
            getUserList().forEach{
                if(it.username == edtEmail.text.toString() && it.password == edtPassword.text.toString()){
                    userFound = true
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", it.username)
                    startActivity(intent)
                }
            }

            if(!userFound){
                Toast.makeText(this, "Invalid username and password", Toast.LENGTH_SHORT).show()
            }

        }

        btnCreateAccount = findViewById(R.id.btnCreateAccount)
        btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtForgetPassword.setOnClickListener {
            val username = edtEmail.text.toString()
            val userPassword = getPassword(username)

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
            intent.putExtra(Intent.EXTRA_TEXT, "Your password is: $userPassword")

            // Choose the email app to send the password
            startActivity(Intent.createChooser(intent, "Send email"))
        }
    }

    fun getPassword(username: String): String{
        var password = ""
        if(username.isNotEmpty()){
            getUserList().forEach {
                if(it.username == username){
                    password = it.password
                }
            }
        }
        return password
    }


}