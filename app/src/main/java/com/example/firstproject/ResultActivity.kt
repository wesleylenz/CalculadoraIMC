package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val TVresult2 = findViewById<TextView>(R.id.TVresult2)
        val TVclassificacao = findViewById<TextView>(R.id.TVclassificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val resultformatado = String.format("%.2f", result)

        TVresult2.text = resultformatado

        var classificacao = ""

        if (result < 18.5f) {
            TVclassificacao.setTextColor(ContextCompat.getColor(this, R.color.abaixo))
            classificacao= "Abaixo do peso"
        } else if (result in 18.5f..24.9f) {
            TVclassificacao.setTextColor(ContextCompat.getColor(this, R.color.normal))
            classificacao= "Normal"
        } else if (result in 25.0f..29.9f) {
            TVclassificacao.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
            classificacao= "Sobrepeso"
        } else if (result in 30.0f..39.9f) {
            TVclassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidade))
            classificacao= "Obesidade"
        } else if (result >= 40.0f) {
            TVclassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidadeG))
            classificacao= "Obesidade grave"
        }

            TVclassificacao.text = getString(R.string.messages_classificacao, classificacao)
     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }
    }





