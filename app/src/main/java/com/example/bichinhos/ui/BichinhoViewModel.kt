package com.example.bichinhos.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
/*import com.example.bichinhos.db.Banco*/
import com.example.bichinhos.model.Bichinho
import com.example.bichinhos.repository.BichinhoRepository
import kotlinx.coroutines.launch

class BichinhoViewModel(app : Application) : AndroidViewModel(app) {

    var bichinho = MutableLiveData<Bichinho>()
    var repository = BichinhoRepository()
    var listaDeBichinhos = repository.listaDeBichinhos


}