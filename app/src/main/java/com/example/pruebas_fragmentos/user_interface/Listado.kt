package com.example.pruebas_fragmentos.user_interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebas_fragmentos.Adaptador
import com.example.pruebas_fragmentos.Producto
import com.example.pruebas_fragmentos.R
import com.example.pruebas_fragmentos.databinding.ActivityListadoBinding
import com.example.pruebas_fragmentos.dto.WsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Listado : AppCompatActivity() {
    private lateinit var views: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(views.root)
        initialConfiguration()
        addListProducts()
    }

    private fun initialConfiguration() {
        views.listItem.layoutManager = LinearLayoutManager(this)
    }

    private fun addListProducts() {
        WsClient.api()?.buscarListaProductos()?.enqueue(object : Callback<List<Producto>> {
            override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                if (response.isSuccessful){
                    val list = response.body()!!
                    views.listItem.adapter = Adaptador(list)
                }else{
                    Toast.makeText(
                        this@Listado,
                        android.R.string.httpErrorBadUrl,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Toast.makeText(
                    this@Listado,
                    android.R.string.httpErrorBadUrl,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}

