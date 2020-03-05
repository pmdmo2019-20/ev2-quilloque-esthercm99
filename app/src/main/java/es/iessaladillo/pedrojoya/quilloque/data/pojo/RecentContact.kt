package es.iessaladillo.pedrojoya.quilloque.data.pojo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class RecentContact (
    val id: Long,
    var phoneNumber: String,
    var type: String,
    var date: String,
    var time: String,
    var contactId: Long,
    var name: String
)