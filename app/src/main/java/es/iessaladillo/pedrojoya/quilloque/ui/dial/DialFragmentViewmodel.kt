package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.RecentsDao
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentCall
import kotlin.concurrent.thread

class DialFragmentViewmodel (private val recentsDao: RecentsDao, private val application: Application) : ViewModel() {

    var currentNumber: MutableLiveData<String> = MutableLiveData("")
    private var recentContacts: LiveData<List<RecentCall>>? = null

    fun getRecentCall() {
        thread {
            recentContacts = recentsDao.querySugerenceContacts("%$currentNumber%")
        }
    }

    fun setCurrentNumber(number: String) {
        currentNumber.value = currentNumber.value + number
    }
    fun eraseAnNumberOfCurrentNumber() {
        if (!currentNumber.value.isNullOrEmpty()) {
            val number = currentNumber.value
            currentNumber.value = number?.substring(0, currentNumber.value!!.length-1)
        }
    }
}