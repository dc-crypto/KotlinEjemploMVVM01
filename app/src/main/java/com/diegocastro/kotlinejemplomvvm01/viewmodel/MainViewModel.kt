package com.diegocastro.kotlinejemplomvvm01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegocastro.kotlinejemplomvvm01.repository.Frutas
import com.diegocastro.kotlinejemplomvvm01.repository.FrutasInteractor

class MainViewModel: ViewModel(){

    private val lista: MutableLiveData<List<Frutas>> = MutableLiveData()
    //Creamos instancia de la clase frutas interactor
    private val interactor= FrutasInteractor()

    //creamos la funcion que recibe la lista de frutas
    fun setListData(listaFrutas: List<Frutas>){
        lista.value=listaFrutas
    }

    fun getListaData():LiveData<List<Frutas>>{
        return lista
    }

    // Creamos 2 funciones que llamen

    fun cargarFrutas1ROOM(){
        //traemos las frutas y lo guardamos en el set cuando cambia el calor
        setListData(interactor.obtenerFrutasROOM())

    }

    fun cargarFrutas2RETROFIT(){
        setListData(interactor.obtenerFrutasAPIRETROFIT())
    }
}