package com.example.project.model

import java.io.Serializable

data class Event(var id: Int, var nameEvent: String, var dateTime: String) : Serializable {

}