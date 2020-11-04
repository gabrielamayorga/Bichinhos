package com.example.bichinhos.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bichinhos.model.Bichinho
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class BichinhoRepository {

    var listaDeBichinhos = MutableLiveData<MutableList<Bichinho>>()
    private val db = FirebaseFirestore.getInstance()
    init {
        db.collection("bichinhos")
            .get()
            .addOnCompleteListener{docs ->
                if(docs.isSuccessful){
                    var bichinhos = mutableListOf<Bichinho>()
                    docs.result?.forEach {doc ->
                        var bichinho = doc.toObject(Bichinho::class.java)
                        if(bichinho != null){
                            bichinho.id = doc.id
                            bichinhos.add(bichinho)
                        }
                    }
                    listaDeBichinhos.value = bichinhos
                }else{
                    listaDeBichinhos.value = mutableListOf()
                }
            }

        db.collection("bichinhos")
            .addSnapshotListener{ snapshot, _ ->
                if(snapshot != null){
                    var bichinhos = mutableListOf<Bichinho>()
                    snapshot.documents.forEach {doc ->
                        var bichinho = doc.toObject(Bichinho::class.java)
                        if(bichinho != null){
                            bichinho.id = doc.id
                            bichinhos.add(bichinho)
                        }
                    }
                    listaDeBichinhos.value = bichinhos
                }

            }
    }

    fun salvarBichinho(bichinho: Bichinho){
        if(bichinho.id.isBlank()){
            var doc = db.collection("bichinhos").document()
            bichinho.id = doc.id
            doc.set(bichinho)
        }else{
            db.collection("bichinhos")
                .document(bichinho.id)
                .set(bichinho)
        }
    }

    fun excluirBichinho(id : String){
        db.collection("bichinhos")
            .document(id)
            .delete()
    }

}