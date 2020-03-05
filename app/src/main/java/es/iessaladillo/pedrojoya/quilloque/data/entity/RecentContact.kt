package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact",
    primaryKeys = ["name", "phoneNumber"]
)
data class RecentContact (
    @PrimaryKey(autoGenerate = true) val  callId: Long,
    var name: String,
    var phoneNumber: Long,
    var date: String,
    var time: String
)