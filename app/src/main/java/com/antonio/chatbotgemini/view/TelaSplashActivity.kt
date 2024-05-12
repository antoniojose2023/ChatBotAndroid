package com.antonio.chatbotgemini.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.antonio.chatbotgemini.databinding.ActivityTelaSplashBinding


class TelaSplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivityTelaSplashBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        modoTelaCheia()

        Handler().postDelayed({
             startActivity(Intent(this, MainActivity::class.java))
             finish()
        }, 3000)

    }


    private fun modoTelaCheia(){
        val decorView = window.decorView
        // Esconde tanto a barra de navegação e a barra de status .
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        decorView.systemUiVisibility = uiOptions
    }
}