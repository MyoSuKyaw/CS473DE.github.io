package com.android_de.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val username = intent.getStringExtra("username")

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)
        txtWelcome.text = "Welcome $username"

        imageView1 = findViewById(R.id.imageView1)
        imageView1.setOnClickListener{
            Toast.makeText(this, "Electronic Devices", Toast.LENGTH_SHORT).show()
        }

        imageView2 = findViewById(R.id.imageView2)
        imageView2.setOnClickListener{
            Toast.makeText(this, "Cosmetics", Toast.LENGTH_SHORT).show()
        }

        imageView3 = findViewById(R.id.imageView3)
        imageView3.setOnClickListener{
            Toast.makeText(this, "Clothing", Toast.LENGTH_SHORT).show()
        }

        imageView4 = findViewById(R.id.imageView4)
        imageView4.setOnClickListener{
            Toast.makeText(this, "Vegetables", Toast.LENGTH_SHORT).show()
        }
    }
}