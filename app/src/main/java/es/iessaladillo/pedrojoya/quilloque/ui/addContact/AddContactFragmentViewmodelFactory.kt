package es.iessaladillo.pedrojoya.quilloque.ui.addContact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.ContactsDao

class AddContactFragmentViewmodelFactory (private val contactsDao: ContactsDao, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = AddContactFragmentViewmodel(contactsDao, application) as T
}