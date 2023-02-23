package com.example.project.model

data class User(
    val id_user: Int,
    var userName: String,
    val email: String,
    val password: String,
    val phone: String
) {
    companion object {
        const val TABLE_NAME: String = "user"
        const val ID: String = "id_user"
        const val NAME: String = "username"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val PHONE = "phone"
    }
}