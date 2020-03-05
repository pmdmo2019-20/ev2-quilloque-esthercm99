package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RecentFragmentViewmodelFactory (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RecentFragmentViewmodel(application) as T
}