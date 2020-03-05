package es.iessaladillo.pedrojoya.quilloque.ui.addContact

import android.app.Application
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.ContactsDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import kotlin.concurrent.thread

class AddContactFragmentViewmodel (private val contactsDao: ContactsDao, private val application: Application) : ViewModel() {

    fun createContact(contact: Contact) {
        thread {
            contactsDao.insertContact(contact)
        }
    }
}