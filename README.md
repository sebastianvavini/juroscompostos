# Juros Compostos



 buildFeatures{
        viewBinding true
    }
    
 ======================================================================================================


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.henhein.gastoscomviagemclean.databinding.ActivityMainBinding 
    
    class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)

        //supportActionBar?.hide()

      //  binding.buttonSetRoute.setOnClickListener(this)
       // binding.buttonBuyHere.setOnClickListener(this)

    }

    override fun onClick(v: View) {


        if(v.id==R.id.button_calculate) {
            if (isValid()) {
                calculate()
            } else {
                Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show()
            }
        }


    }
    private fun isValid(): Boolean {
        return binding.editTextDistance.text.toString()!="" &&
                binding.editTextPrice.text.toString()!=""&&
                binding.editTextAutonomy.text.toString()!="" &&
                binding.editTextAutonomy.text.toString().toFloat()!=0f

    }
    private fun calculate(){
        var distance =binding.editTextDistance.text.toString().toFloat()
        var price= binding.editTextPrice.text.toString().toFloat()
        var autonomy= binding.editTextAutonomy.text.toString().toFloat()
        var resultado=distance*price/autonomy


        binding.textViewResult.text = "R$ ${"%.2f".format(resultado)}"
        println("Calcula mizerávé R$ ${resultado}")

    }
    private fun definirRota(){
        println("Definição de rota iniciando...")
    }
    private fun comprarCombustivel(){
        println("Comprando na promoção...")
    }
}
