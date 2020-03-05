package es.iessaladillo.pedrojoya.quilloque.data.pojo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class RecentCall (
    var contactName: String,
    var phoneNumber: String
)