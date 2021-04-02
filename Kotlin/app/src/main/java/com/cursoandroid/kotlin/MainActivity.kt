package com.cursoandroid.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sortearNumero(view: View){

        var texto = findViewById<TextView>(R.id.resultado)
        var numeroSorteado = Random.nextInt(10);

        texto.setText("Numero sorteado e: " + numeroSorteado)
        //or
        texto.text = "Numero sorteado e: " + numeroSorteado

    }

}