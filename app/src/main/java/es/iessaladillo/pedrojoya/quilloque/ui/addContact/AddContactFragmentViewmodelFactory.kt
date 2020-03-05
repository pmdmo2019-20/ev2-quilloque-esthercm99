package es.iessaladillo.pedrojoya.quilloque.ui.addContact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddContactFragmentViewmodelFactory (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = AddContactFragmentViewmodel(application) as T
}