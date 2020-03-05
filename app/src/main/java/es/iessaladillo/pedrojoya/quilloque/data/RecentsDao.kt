package es.iessaladillo.pedrojoya.quilloque.data

import androidx.lifecycle.LiveData
import androidx.room.*
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.quilloque.data.pojo.ContactCall
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentCall
@Dao
interface RecentsDao {

    @Insert
    fun insertCall(call: Call)

    @Query("SELECT C.id AS callId, C.phoneNumber AS phoneNumber, C.type AS type, " +
            "C.date AS date, C.time AS time, T.id AS contactId, T.name AS contactName " +
            "FROM Call AS C LEFT JOIN Contact AS T ON C.phoneNumber = T.phoneNumber " +
            "ORDER BY C.id DESC LIMIT :limit")
    fun queryRecentCalls(limit: Long): LiveData<List<ContactCall>>

    @Query("SELECT name AS contactName, phoneNumber AS phoneNumber " +
            "FROM Contact " +
            "WHERE phoneNumber like :phoneNumber " +
            "UNION " +
            "SELECT DISTINCT phoneNumber AS contactName, phoneNumber AS phoneNumber " +
            "FROM Call " +
            "WHERE phoneNumber like :phoneNumber " +
            "AND phoneNumber NOT IN (SELECT phoneNumber FROM Contact)")
    fun querySugerenceContacts(phoneNumber: String): LiveData<List<RecentCall>>

}