package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ID'S
        val btnCalcule: Button = findViewById(R.id.btnCalculate)
        val ETaltura: EditText = findViewById(R.id.ETaltura)
        val ETpeso: EditText = findViewById(R.id.ETpeso)

        btnCalcule.setOnClickListener {

        //CÁLCULO DO IMC
        val alturaStr= ETaltura.text.toString()
        val pesoStr= ETpeso.text.toString()

        if (alturaStr.isNotEmpty()&& pesoStr.isNotEmpty()) {


            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

            val alturaFinal: Float = altura * altura
            var result = peso / alturaFinal

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)

        }else{
          Toast.makeText(this, "Por favor preencher todos os campos", Toast.LENGTH_LONG).show()
        }

        }
    }
}