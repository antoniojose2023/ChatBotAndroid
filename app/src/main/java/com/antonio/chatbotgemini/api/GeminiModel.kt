package com.antonio.chatbotgemini.api

import com.google.ai.client.generativeai.GenerativeModel

class GeminiModel {

    val gemini = GenerativeModel(
        modelName = Constantes.MODEL_GEMINI,
        apiKey = Constantes.API_KEY
    )

    suspend fun getGeneretareContent(prompt: String): String{
         return gemini.generateContent( prompt ).text!!
    }

    suspend fun getStartConversion(prompt: String): String{
        return gemini.startChat().sendMessage( prompt ).text!!
    }
}