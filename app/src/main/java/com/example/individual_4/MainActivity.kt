package com.example.individual_4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var numero1: EditText? = null
    private var numero2: EditText? = null
    private var sumar: Button? = null
    private var restar: Button? = null
    private var multiplicar: Button? = null
    private var dividir: Button? = null
    private var resultado: EditText? = null
    private var salir: Button? = null

    //ahora se usa var enves de int como en java

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numero1 = findViewById(R.id.numero1)
        numero2 = findViewById(R.id.numero2)
        sumar = findViewById(R.id.sumar)
        restar = findViewById(R.id.restar)
        multiplicar = findViewById(R.id.multiplicar)
        dividir = findViewById(R.id.dividir)
        resultado = findViewById(R.id.resultado)
        salir = findViewById(R.id.salir)


        sumar.setOnClickListener(View.OnClickListener { calcular('+') })

        restar.setOnClickListener(View.OnClickListener { calcular('-') })

        multiplicar.setOnClickListener(View.OnClickListener { calcular('*') })

        dividir.setOnClickListener(View.OnClickListener { calcular('/') })

        salir.setOnClickListener(View.OnClickListener { finish() })
    }

    private fun calcular(operador: Char) {
        val num1 = numero1!!.text.toString()
        val num2 = numero2!!.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            resultado!!.setText("Esto funcionaria mejor con numeros")
            return
        }

        val numero1Valor = num1.toDouble()
        val numero2Valor = num2.toDouble()
        var resultadoValor = 0.0


        // ahora se usa when en ves de switch
        when (operador) {
            '+' -> resultadoValor = numero1Valor + numero2Valor
            '-' -> resultadoValor = numero1Valor - numero2Valor
            '*' -> resultadoValor = numero1Valor * numero2Valor
            '/' -> if (numero2Valor != 0.0) {
                resultadoValor = numero1Valor / numero2Valor
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "CUIDADO QUE CON ESTO EL UNIVERSO EXPLOTARA!",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

        }
        resultado!!.setText(resultadoValor.toString())
    }
}
