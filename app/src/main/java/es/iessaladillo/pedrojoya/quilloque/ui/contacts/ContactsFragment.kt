package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import es.iessaladillo.pedrojoya.quilloque.R
import kotlinx.android.synthetic.main.contacts_fragment.*
import kotlinx.android.synthetic.main.main_activity.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import es.iessaladillo.pedrojoya.quilloque.base.OnToolbarAvailableListener
import es.iessaladillo.pedrojoya.quilloque.data.DatabaseContact
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact


class ContactsFragment : Fragment() {

    private lateinit var contactsAdapter: ContactsFragmentAdapter

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(navHostFragment)
    }
    private val viewmodel: ContactsFragmentViewmodel by viewModels {
        ContactsFragmentViewmodelFactory(DatabaseContact.getInstance(this.requireContext()).contactsDao, requireActivity().application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnuAdd -> navigateToCreateContact()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contacts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
        setupAdapter()
        setupRecyclerView()
        submitContacts()
    }

    private fun setupViews() {
        emptyView.setOnClickListener { navigateToCreateContact() }
    }

    private fun navigateToCreateContact() = navController.navigate(R.id.addContactFragment)

    private fun setupAdapter() {
        contactsAdapter = ContactsFragmentAdapter().also {
            it.onItemClickListener = { position ->  }
        }
    }
    private fun setupRecyclerView() {
        lstContacts.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 1)
            adapter = contactsAdapter
        }
    }

    private fun submitContacts() {
        viewmodel.submitContacts()
        viewmodel.contactsList.observe(this) {
            showCalls(it)
        }
    }
    private fun showCalls(callsList: List<Contact>) {
        lstContacts.post {
            contactsAdapter.submitList(callsList)
            lstContacts.visibility = if (callsList.isNotEmpty()) View.VISIBLE else View.INVISIBLE
            emptyView.visibility = if (callsList.isEmpty()) View.VISIBLE else View.INVISIBLE
        }
    }
    private fun changeView(editText: EditText, default: String) {
        txtSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable) {

            }
        })
    }
}