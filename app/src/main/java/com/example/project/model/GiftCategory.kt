package com.example.project.model


data class GiftCategory(val id: Int, val name: String, val imageView: String) {
    companion object {
        const val TABLE_NAME: String = "gift_category"
        const val ID: String = "id"
        const val NAME: String = "name"
        const val IMAGE: String = "image"
    }
}