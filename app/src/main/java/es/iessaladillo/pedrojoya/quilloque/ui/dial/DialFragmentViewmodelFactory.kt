package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DialFragmentViewmodelFactory  (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DialFragmentViewmodel(application) as T
}