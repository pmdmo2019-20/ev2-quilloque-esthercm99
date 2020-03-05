package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.RecentsDao
import es.iessaladillo.pedrojoya.quilloque.data.pojo.ContactCall
import kotlin.concurrent.thread

class RecentFragmentViewmodel (private val recentsDao: RecentsDao, private val application: Application) : ViewModel() {

    var recentContacts: LiveData<List<ContactCall>> = recentsDao.queryRecentCalls(10)

    init {
        recentContacts = recentsDao.queryRecentCalls(10)
    }

    fun submitRecentCall() {
        recentContacts = recentsDao.queryRecentCalls(10)
    }
}