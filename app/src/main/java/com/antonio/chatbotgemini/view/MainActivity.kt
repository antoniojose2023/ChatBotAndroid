package com.antonio.chatbotgemini.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.antonio.chatbotgemini.api.GeminiModel
import com.antonio.chatbotgemini.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.animationView.visibility = View.INVISIBLE

        binding.btEnviar.setOnClickListener {
            val prompt = binding.editPrompot.text.toString()
            if(prompt.isNotEmpty()){
                   binding.animationView.visibility = View.VISIBLE
                   getReponsePrompot(prompt)
            }else{
                Toast.makeText(this, "Campo vázio . . .", Toast.LENGTH_LONG).show()
            }
        }



    }

    private fun getReponsePrompot(prompt: String){
        val generativeModel = GeminiModel()

        CoroutineScope(Dispatchers.IO).launch {
            val resposta = generativeModel.getGeneretareContent( prompt )

            withContext(Dispatchers.Main){
                binding.animationView.visibility = View.GONE
                binding.tvResposta.text = "Resposta -> \n ${resposta.toString()}"
            }
        }
    }
}