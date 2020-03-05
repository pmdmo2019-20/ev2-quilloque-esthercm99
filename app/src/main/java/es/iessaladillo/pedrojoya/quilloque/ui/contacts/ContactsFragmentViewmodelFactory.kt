package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactsFragmentViewmodelFactory (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ContactsFragmentViewmodel(application) as T
}