package com.diegocastro.kotlinejemplomvvm01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegocastro.kotlinejemplomvvm01.R
import com.diegocastro.kotlinejemplomvvm01.databinding.ActivityMainBinding
import com.diegocastro.kotlinejemplomvvm01.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    //desde la vista tenemos que comunicarnos con el viewmodel creamos una instancia
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        //invocamos al metodo observar y lo creamos
        observar()

        binding.btnLista.setOnClickListener {
            mainViewModel.cargarFrutas1ROOM()
        }

        binding.btnAgregarOtraFruta.setOnClickListener {
            mainViewModel.cargarFrutas2RETROFIT()
        }
    }

    private fun observar() {
        //invocamos lo que queremos observar que seria la lista
        mainViewModel.getListaData().observe(this, Observer {
            for(fruta in it){
                Log.d("Fruta",fruta.nombreFruta)
            }
        })
    }
}