package com.example.gasolinacalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular.setOnClickListener {
            resultadoConta.text = (gasolina.text.toString().toFloat() * 0.7).toString()
            Log.i("CALCULADORA", "Valor Gasolina:${gasolina.text}")
            Log.i("CALCULADORA", "Valor Alcool:${alcool.text}")
            Log.i("CALCULADORA", "Resultado da Conta:${resultadoConta.text}")

            if (resultadoConta.text.toString().toFloat() > alcool.text.toString().toFloat()){
                qualComprar.text = "Alcool"
                Log.i("CALCULADORA", "Compra Alcool")
            }else{
                qualComprar.text = "Gasolina"
                Log.i("CALCULADORA", "Compra Gasolina")
            }
        }
    }
}
