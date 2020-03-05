package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.RecentsDao

class RecentFragmentViewmodelFactory (private val recentsDao: RecentsDao, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RecentFragmentViewmodel(recentsDao, application) as T
}