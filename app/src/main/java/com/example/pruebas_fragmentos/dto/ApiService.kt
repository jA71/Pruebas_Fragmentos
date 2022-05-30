package com.example.pruebas_fragmentos.dto


import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET( "index.php")
    fun buscarListaProdcutos(): Call <List<Producto>>
}