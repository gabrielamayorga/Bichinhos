package com.example.bichinhos.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bichinhos.R

class BichinhoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val nomeBichinho: TextView = view.findViewById(R.id.texto_nomeBichinho)
    val nomeDono: TextView = view.findViewById(R.id.texto_nomeDono)
    var fotoBichinho: ImageView = view.findViewById(R.id.imgFoto)


    override fun toString(): String {
        return super.toString() + " '" + nomeBichinho.text + "'"
    }
}
