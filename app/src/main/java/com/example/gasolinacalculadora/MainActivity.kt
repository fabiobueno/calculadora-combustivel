package com.example.gasolinacalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gasolina.addTextChangedListener(MoneyTextWatcher(gasolina))
        alcool.addTextChangedListener(MoneyTextWatcher(alcool))
        resultadoConta.addTextChangedListener(MoneyTextWatcher(alcool))

        calcular.setOnClickListener {
            if (gasolina.text.toString() == "" || alcool.text.toString() == ""){
                Toast.makeText(this, "Preencha os valores", Toast.LENGTH_LONG).show()
            }else {
                resultadoConta.text =
                    (gasolina.text.toString().replace(",", "").toFloat() * 0.7).toString()
                Log.i("CALCULADORA", "Valor Gasolina:${gasolina.text}")
                Log.i("CALCULADORA", "Valor Alcool:${alcool.text}")
                Log.i("CALCULADORA", "Resultado da Conta:${resultadoConta.text}")

                if (resultadoConta.text.toString().toFloat() > alcool.text.toString().replace(
                        ",",
                        ""
                    ).toFloat()
                ) {
                    qualComprar.text = "Alcool"
                    Log.i("CALCULADORA", "Compra Alcool")
                } else {
                    qualComprar.text = "Gasolina"
                    Log.i("CALCULADORA", "Compra Gasolina")
                }
            }
        }
    }
}
