package com.example.project.model


data class Wish(var id :Int, var id_category: String,var wish : String ) {
    companion object {
        const val TABLE_NAME = "wish"
        const val ID = "id"
        const val ID_CATEGORY = "id_categoyr"
        const val WISH = "wish"
    }
}