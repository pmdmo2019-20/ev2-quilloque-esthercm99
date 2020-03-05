package es.iessaladillo.pedrojoya.quilloque.ui.addContact

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.DatabaseContact
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import kotlinx.android.synthetic.main.contact_creation_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class AddContactFragment : Fragment() {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(navHostFragment)
    }
    private val viewmodel: AddContactFragmentViewmodel by viewModels {
        AddContactFragmentViewmodelFactory(DatabaseContact.getInstance(this.requireContext()).contactsDao, requireActivity().application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_creation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupViews()
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            title = getString(R.string.contact_creation_title)
            setSupportActionBar(toolbar)
            setupActionBarWithNavController(navController)
        }
    }

    private fun setupViews() {
        addContact()
    }
    private fun addContact() {
        fabSave.setOnClickListener {
            if(txtName.text.isNullOrEmpty() || txtPhoneNumber.text.isNullOrEmpty()) {
                Toast.makeText(context, "Name or number phone is empty, try again", Toast.LENGTH_SHORT).show()
            } else {
                viewmodel.createContact(Contact(0, txtName.text.toString(), txtPhoneNumber.text.toString()))
                navController.navigateUp()
            }
        }
    }
}