package com.example.bichinhos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}