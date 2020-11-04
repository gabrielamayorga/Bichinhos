package com.example.bichinhos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.bichinhos.R
import com.example.bichinhos.model.Bichinho
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A fragment representing a list of Items.
 */
class ListaDeBichinhoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_de_bichinhos, container, false)
        var recycler = view.findViewById<RecyclerView>(R.id.list)
        var viewModel = ViewModelProvider(requireActivity()).get(BichinhoViewModel::class.java)

        viewModel.listaDeBichinhos.observe(requireActivity(), { bichinhos ->
            with(recycler) {
                adapter = BichinhoAdapter(requireActivity(), viewModel, bichinhos)
            }
        })


        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            viewModel.bichinho.value = Bichinho()
            findNavController().navigate(R.id.action_lista_detalhes_bichinho)
        }
        return view
    }


}