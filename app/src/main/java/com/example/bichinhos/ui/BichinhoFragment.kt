package com.example.bichinhos.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.bichinhos.R
import com.example.bichinhos.model.Bichinho
import kotlinx.android.synthetic.main.bichinho_fragment.*

class BichinhoFragment : Fragment() {

    private lateinit var viewModel: BichinhoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.bichinho_fragment, container, false)
        viewModel = ViewModelProvider(this).get(BichinhoViewModel::class.java)

        viewModel.bichinho.observe(viewLifecycleOwner, { bichinho ->

            txtNome.setText(bichinho.bichinho)
            txtDono.setText(bichinho.dono)
            txtAniver.setText(bichinho.Aniversario)
            txtFoto.setText(bichinho.foto)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener{
                var bichinho = Bichinho(
                    id = bichinho.id,
                    bichinho= txtNome.text.toString(),
                    dono = txtDono.text.toString(),
                    foto = txtFoto.text.toString(),
                    aniversario = txtAniver.text.toString()
                )



                viewModel.repository.salvarBichinho(bichinho)
                findNavController().navigateUp()
            }

        })

        return view
    }
}