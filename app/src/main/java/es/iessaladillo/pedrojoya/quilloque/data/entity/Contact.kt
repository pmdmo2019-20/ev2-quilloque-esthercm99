package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.Entity

@Entity(
    tableName = "contact",
    primaryKeys = ["name", "phoneNumber"]
)
data class Contact (
    var name: String,
    var phoneNumber: Long
)