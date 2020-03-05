package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.RecentsDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentCall
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class DialFragmentViewmodel (private val recentsDao: RecentsDao, private val application: Application) : ViewModel() {

    var currentNumber: MutableLiveData<String> = MutableLiveData("")
    var suggestionsContacts: LiveData<List<RecentCall>> = recentsDao.querySugerenceContacts("")

    fun submitSuggestionsCall() {
        suggestionsContacts  = recentsDao.querySugerenceContacts(currentNumber.value.toString())
    }

    fun callNumber(type: String) {

        if(!currentNumber.value.isNullOrEmpty()) {
            val currentDate = SimpleDateFormat("dd/MM/yyyy-HH:mm").format(Date())
            val splitCurrent =  currentDate.split("-")
            val date = splitCurrent[0]
            val time = splitCurrent[1]

            val call = Call(0, currentNumber.value!!, type, date, time)

            thread {
                recentsDao.insertCall(call)
            }

            Toast.makeText(application.applicationContext, String.format("Call made on %s %s", date, time), Toast.LENGTH_SHORT).show()
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