package com.example.project.model

data class Category(var id: Int, val name: String, val createAt: String) {
    companion object {
        const val TABLE_NAME: String = "category"
        const val ID: String = "id"
        const val NAME: String = "name"
        const val CREATE_AT = "createat"
    }
}