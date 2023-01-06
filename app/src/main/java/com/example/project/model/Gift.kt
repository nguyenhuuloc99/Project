package com.example.project.model

data class Gift(var id :Int, var id_category :String,var url : String) {
    companion object {
        const val TABLE_NAME = "gift"
        const val ID = "id"
        const val ID_CATEGORY = "id_category"
        const val URL = "url"
    }
}