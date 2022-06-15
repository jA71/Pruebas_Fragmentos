package com.example.pruebas_fragmentos.dto


import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET( "index.php")
    fun buscarListaProductos(): Call <List<Producto>>

    @Headers("Content-Type: application/json")
    @POST("autentication/login")
    fun logearse(
        @Body usuario: Usuario
        ): Call<String>
}