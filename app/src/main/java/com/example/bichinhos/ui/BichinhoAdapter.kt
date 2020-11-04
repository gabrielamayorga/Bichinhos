package com.example.bichinhos.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.bichinhos.R
import com.example.bichinhos.model.Bichinho
import com.google.firebase.storage.FirebaseStorage

class BichinhoAdapter(
    private val activity: FragmentActivity,
    private val viewModel: BichinhoViewModel,
    private val bichinhos: List<Bichinho>
) : RecyclerView.Adapter<BichinhoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BichinhoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bichinho, parent, false)
        return BichinhoViewHolder(view)
    }

    override fun onBindViewHolder(holder: BichinhoViewHolder, position: Int) {

        val bichinho = bichinhos[position]
        holder.nomeBichinho.text = bichinho.bichinho
        holder.nomeDono.text = bichinho.dono

        val storage = FirebaseStorage.getInstance()
        var storageReference = storage.getReference(bichinho.foto)
        storageReference.downloadUrl.addOnSuccessListener { imageUrl ->
            Glide.with(activity)
                .load(imageUrl)
                .into(holder.fotoBichinho)
        }

        storageReference.downloadUrl.addOnFailureListener{
              Glide.with(activity)
                  .load(R.drawable.fofinho)
                  .into(holder.fotoBichinho)
        }

        holder.itemView.setOnClickListener{view ->
            viewModel.bichinho.value = bichinho
            view.findNavController().navigate(R.id.action_lista_detalhes_bichinho)
        }

        holder.itemView.setOnLongClickListener{view ->
            view?.let{
                AlertDialog.Builder(activity)
                    .setTitle("Leia")
                    .setMessage("Deseja excluir bichinho?")
                    .setPositiveButton("Sim"){dialog, which ->
                        viewModel.repository.excluirBichinho(bichinho.id)
                    }
                    .setNegativeButton("Não", null)
                    .show()
            }
           true
        }
    }

    override fun getItemCount(): Int = bichinhos.size

}