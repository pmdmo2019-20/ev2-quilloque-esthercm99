package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.RecentsDao
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentContact

class DialFragmentViewmodel (private val application: Application) : ViewModel() {

    var currentNumber: MutableLiveData<String> = MutableLiveData("")
    //private var recentContacts: LiveData<List<RecentContact>>? = null
/*
    fun getRecentCall() {
        thread {
            recentContacts = recentsDao.queryRecentCalls("%$currentNumber%")
        }
    }
*/
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