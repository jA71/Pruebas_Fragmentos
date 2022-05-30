package com.example.pruebas_fragmentos

import android.view.View
import com.example.pruebas_fragmentos.databinding.FragmentProductoBinding

class Adaptador {

    inner class ProductoHolder(fragmentoView: View) {
        val viewHolder: FragmentProductoBinding

        init {
            viewHolder = FragmentProductoBinding.bind(fragmentoView)
        }
    }
}