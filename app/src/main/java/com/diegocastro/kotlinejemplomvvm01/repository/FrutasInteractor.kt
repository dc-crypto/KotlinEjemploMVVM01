package com.diegocastro.kotlinejemplomvvm01.repository

class FrutasInteractor {
    //esta es la clase que hace la gestion de datos tenemos los metodos que se conectarian a room o retrofit

    fun obtenerFrutasROOM(): List<Frutas>{
        val frutas = listOf<Frutas>(
            Frutas("Piña","Amarilla",1500f,1f),
            Frutas("Manzana","Roja",1500f,1f),
            Frutas("Frutilla","Roja",1500f,1f)
        )
        return frutas
    }
    fun obtenerFrutasAPIRETROFIT(): List<Frutas> {
        val frutas = listOf<Frutas>(
            Frutas("Sandia", "Roja", 1500f, 1f),
            Frutas("Melon", "verde", 1500f, 1f),
            Frutas("Uva", "negra", 1500f, 1f)
        )
        return frutas
    }
}