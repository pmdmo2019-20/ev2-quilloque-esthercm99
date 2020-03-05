package es.iessaladillo.pedrojoya.quilloque.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

@Dao
interface ContactsDao {
    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}