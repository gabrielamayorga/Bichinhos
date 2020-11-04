package com.example.bichinhos.model

import androidx.room.PrimaryKey


data class Bichinho (
    var id : String,
    var bichinho : String,
    var dono : String,
    var foto : String,
    var Aniversario : String
)
{
    constructor() : this(String(),String(), String(), String(), String())
}



