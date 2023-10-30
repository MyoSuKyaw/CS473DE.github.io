package com.android_de.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var foodArr = mutableListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private lateinit var btnDecide: Button
    private lateinit var txtFood: TextView
    private lateinit var btnAddFood: Button
    private lateinit var edtFood: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecide = findViewById(R.id.btnDecide)
        btnDecide.setOnClickListener{
            showRandomFood()
        }

        btnAddFood = findViewById(R.id.btnAddFood)
        edtFood = findViewById(R.id.edtFood)
        btnAddFood.setOnClickListener{
            val food = edtFood.text.toString()
            if(food.isNotEmpty()){
                foodArr.add(food)
                Toast.makeText(applicationContext, "$food is added!!!", Toast.LENGTH_SHORT).show()
                edtFood.text.clear()
            }else{
                Toast.makeText(applicationContext, "please enter food", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun showRandomFood(){
        if(foodArr.isNotEmpty()){
            val randomIndex = Random.nextInt(foodArr.size)
            val randomData = foodArr[randomIndex]
            txtFood = findViewById(R.id.txtFood)
            txtFood.text = randomData
        }
    }
}