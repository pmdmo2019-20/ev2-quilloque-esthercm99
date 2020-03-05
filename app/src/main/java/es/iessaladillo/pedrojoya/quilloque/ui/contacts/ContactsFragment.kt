package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import es.iessaladillo.pedrojoya.quilloque.R
import kotlinx.android.synthetic.main.contacts_fragment.*
import kotlinx.android.synthetic.main.main_activity.*
import android.view.Menu
import android.view.MenuInflater




class ContactsFragment : Fragment() {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contacts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupToolbar()
        setupViews()
    }

    private fun setupViews() {
        emptyView.setOnClickListener { navigateToCreateContact() }
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            title = getString(R.string.contacts_title)
            setSupportActionBar(toolbar)
        }

    }

    private fun navigateToCreateContact() = navController.navigate(R.id.addContactFragment)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }
}