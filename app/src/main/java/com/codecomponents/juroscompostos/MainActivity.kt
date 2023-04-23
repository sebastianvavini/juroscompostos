package com.codecomponents.juroscompostos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.codecomponents.juroscompostos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //supportActionBar?.hide()

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(p: View) {
        if(p.id==R.id.button_calculate) {
            if (isValid()) {
                //calculate()
                calculateJurosComAportes()
            } else {
                //R.string.fill_all_fields
                Toast.makeText(this, "algo deu errado", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun isValid(): Boolean {



              //  android:id="@+id/editText_ValorMensal"
              // android:id="@+id/editText_TaxaDeJuros"
              // android:id="@+id/editText_Periodo"

        return binding.editTextValorInicial.text.toString()!="" &&
                binding.editTextValorMensal.text.toString()!=""&&
                binding.editTextTaxaDeJuros.text.toString()!="" &&
                binding.editTextPeriodo.text.toString()!="" //&&
                //binding.editTextAutonomy.text.toString().toFloat()!=0f

    }
    private fun calculate(){
        /** var valorInicial =binding.editTextValorInicial.text.toString().toFloat()
        var valorMensal= binding.editTextValorMensal.text.toString().toFloat()
        var taxaDeJuros= binding.editTextTaxaDeJuros.text.toString().toFloat()
        var periodo = binding.editTextPeriodo.text.toString().toFloat()

         **/


        var valorInicial =binding.editTextValorInicial.text.toString().toDouble()
        var aporteMensal= binding.editTextValorMensal.text.toString().toDouble()
        var taxaDeJuros= binding.editTextTaxaDeJuros.text.toString().toDouble()
        var periodo = binding.editTextPeriodo.text.toString().toDouble()



        var base= (1+taxaDeJuros)
        var expoente= periodo


        var MONTANTE= (valorInicial)*(Math.pow(base,expoente))


       // var  MONTANTE=Math.pow(base,expoente)


        binding.textViewTotal.text = "R$ ${"%.2f".format(MONTANTE)}"


    }
     private fun calculateJurosComAportes(){
        /** var valorInicial =binding.editTextValorInicial.text.toString().toFloat()
        var valorMensal= binding.editTextValorMensal.text.toString().toFloat()
        var taxaDeJuros= binding.editTextTaxaDeJuros.text.toString().toFloat()
        var periodo = binding.editTextPeriodo.text.toString().toFloat()

         **/


        var valorInicial =binding.editTextValorInicial.text.toString().toDouble()
        var aporteMensal= binding.editTextValorMensal.text.toString().toDouble()
        var taxaDeJuros= binding.editTextTaxaDeJuros.text.toString().toDouble()
        var periodo = binding.editTextPeriodo.text.toString().toDouble()

         var MONTANTE=valorInicial

         var contagem=0
        while (contagem<=periodo){



            if(contagem==0){
                MONTANTE=(valorInicial*taxaDeJuros)+valorInicial
            }
            else  if(contagem<periodo) {
               // MONTANTE += (MONTANTE * taxaDeJuros) + aporteMensal
                MONTANTE = (MONTANTE*taxaDeJuros)+MONTANTE+aporteMensal
            }
            contagem +=contagem
                println("Contagem: ${contagem} Montante: ${MONTANTE}" )





        }


        binding.textViewTotal.text = "R$ ${"%.2f".format(MONTANTE)}"


    }


}