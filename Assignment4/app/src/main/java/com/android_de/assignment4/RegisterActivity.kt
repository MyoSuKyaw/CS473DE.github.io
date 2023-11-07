package com.android_de.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtRegisterFirstname: TextInputEditText
    private lateinit var edtRegisterLastname: TextInputEditText
    private lateinit var edtRegisterEmail: TextInputEditText
    private lateinit var edtRegisterPassword: TextInputEditText
    private lateinit var btnRegister: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var userList = LoginActivity().getUserList()

        edtRegisterFirstname = findViewById(R.id.edtRegisterFirstname)
        edtRegisterLastname = findViewById(R.id.edtRegisterLastname)
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail)
        edtRegisterPassword = findViewById(R.id.edtRegisterPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            if(edtRegisterFirstname.text.toString().isNotEmpty() && edtRegisterLastname.text.toString().isNotEmpty()
                && edtRegisterEmail.text.toString().isNotEmpty() && edtRegisterPassword.text.toString().isNotEmpty()){
                val user = User(edtRegisterFirstname.text.toString(), edtRegisterLastname.text.toString(),
                    edtRegisterEmail.text.toString(), edtRegisterPassword.text.toString())
                userList.add(user)
                Log.v("userlist", userList.toString())
                finish()
            }else{
                Toast.makeText(this, "Please enter required data.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}