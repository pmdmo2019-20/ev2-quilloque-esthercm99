package es.iessaladillo.pedrojoya.quilloque.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

@Database(
    entities = [Contact::class, Call::class],
    version = 1,
    exportSchema = true
)
abstract class DatabaseContact : RoomDatabase() {

    abstract val contactsDao: ContactsDao
    abstract val recentsDao: RecentsDao

    companion object {

        @Volatile
        private var INSTANCE: DatabaseContact? = null

        fun getInstance(context: Context): DatabaseContact {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseContact::class.java,
                            "database_contact"
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}