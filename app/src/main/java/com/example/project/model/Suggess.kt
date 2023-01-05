package com.example.project.model

data class Suggess(private var id: Int, val name: String, val image: String) {
    companion object {
        const val TABLE_NAME = "suggess";
        const val ID = "id";
        const val NAME = "name";
        const val IMAGE = "image";

    }
}