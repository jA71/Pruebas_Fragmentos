package com.example.pruebas_fragmentos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebas_fragmentos.databinding.FragmentProductoBinding
import com.example.pruebas_fragmentos.dto.Producto
import com.squareup.picasso.Picasso


class Adaptador(val lista: List<Producto>): RecyclerView.Adapter<Adaptador.ProductoHolder>() {

    inner class ProductoHolder(fragmentoView: View) : RecyclerView.ViewHolder(fragmentoView){
        val viewHolder: FragmentProductoBinding

        init {
            viewHolder = FragmentProductoBinding.bind(fragmentoView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        return ProductoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_producto,parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.viewHolder.nombre.text = lista[position].name
        holder.viewHolder.descripcion.text = lista[position].description
        holder.viewHolder.precio.text = lista[position].price.toString()
        Picasso.get().load(lista[position].url).fit().centerInside().into(holder.viewHolder.image)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}