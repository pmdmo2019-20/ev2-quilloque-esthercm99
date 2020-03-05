package es.iessaladillo.pedrojoya.quilloque.ui.addContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.DatabaseContact
import es.iessaladillo.pedrojoya.quilloque.ui.dial.DialFragmentViewmodel
import es.iessaladillo.pedrojoya.quilloque.ui.dial.DialFragmentViewmodelFactory
import kotlinx.android.synthetic.main.contact_creation_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class AddContactFragment : Fragment() {

    private val viewmodel: DialFragmentViewmodel by viewModels {
        AddContactFragmentViewmodelFactory(DatabaseContact.getInstance(this.requireContext()).contactsDao, requireActivity().application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_creation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            title = getString(R.string.contact_creation_title)
            setSupportActionBar(toolbar)
        }
    }

    private fun setupViews() {
        addContact()
    }
    private fun addContact() {
        fabSave.setOnClickListener {  }
    }
}