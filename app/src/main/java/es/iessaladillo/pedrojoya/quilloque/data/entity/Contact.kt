package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact",
    indices = [
        Index(
            name = "USERS_INDEX_NAME_UNIQUE",
            value = ["name", "phoneNumber"],
            unique = true
        )
    ]
)
data class Contact (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String
)