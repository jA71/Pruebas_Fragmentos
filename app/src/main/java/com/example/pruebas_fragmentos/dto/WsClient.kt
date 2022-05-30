package com.example.pruebas_fragmentos.dto
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class WsClient {
    companion object {

        private const val URL = "http://192.168.1.3/backendRapidoMovil/"
        private var retrofit: Retrofit? = null

        private fun retrofitClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun api(): ApiService? {
            return retrofitClient()?.create(ApiService::class.java)
        }
    }
}