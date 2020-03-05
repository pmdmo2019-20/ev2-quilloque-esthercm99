package es.iessaladillo.pedrojoya.quilloque.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

@Dao
interface ContactsDao {
    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun queryAllContacts() : LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE name LIKE :name")
    fun queryContacts(name: String) : LiveData<List<Contact>>
}