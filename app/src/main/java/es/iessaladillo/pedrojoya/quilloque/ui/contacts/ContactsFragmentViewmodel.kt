package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.ContactsDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

class ContactsFragmentViewmodel (private val contactsDao: ContactsDao, private val application: Application) : ViewModel() {
    var contactsList: LiveData<List<Contact>> = contactsDao.queryAllContacts()

    fun submitContacts() {
        contactsList  = contactsDao.queryAllContacts()
    }
}