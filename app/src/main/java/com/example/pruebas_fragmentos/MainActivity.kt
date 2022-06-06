package com.example.pruebas_fragmentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebas_fragmentos.databinding.ActivityListadoBinding
import com.example.pruebas_fragmentos.databinding.ActivityMainBinding
import com.example.pruebas_fragmentos.dto.WsClient
import com.example.pruebas_fragmentos.user_interface.Listado
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.acceptButton.setOnClickListener {
            goToListadoProductos()
        }

    }

    private fun goToListadoProductos() {
        var intent: Intent = Intent(this, Listado::class.java)
        startActivity(intent)
    }
}
