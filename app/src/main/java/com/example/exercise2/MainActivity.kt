package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            calBMI()
        }
        buttonReset.setOnClickListener {
            reset()
        }
    }

    private fun calBMI(){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val profile = findViewById<ImageView>(R.id.imageViewProfile)
        val bmiValue = findViewById<TextView>(R.id.textViewBMI)
        val bmiResult = findViewById<TextView>(R.id.textViewBMIResult)
        val value = weight.text.toString().toDouble() / ((height.text.toString().toDouble() / 100) * (height.text.toString().toDouble() / 100))
        bmiValue.text = "BMI : " + value.toString()
        if(value < 18.5){
            bmiResult.text = "Underweight"
            profile.setImageResource(R.drawable.under)
        }else if(value >= 18.5 && value <= 24.9){
            bmiResult.text = "Normal"
            profile.setImageResource(R.drawable.normal)
        }else{
            bmiResult.text = "Overweight"
            profile.setImageResource(R.drawable.over)
        }
    }

    private fun reset(){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val profile = findViewById<ImageView>(R.id.imageViewProfile)
        val bmiValue = findViewById<TextView>(R.id.textViewBMI)
        val bmiResult = findViewById<TextView>(R.id.textViewBMIResult)
//        val value = 0
        weight.text = null
        height.text = null
        bmiValue.text = "BMI : "
        bmiResult.text = " "
        profile.setImageResource(R.drawable.empty)
    }
}
