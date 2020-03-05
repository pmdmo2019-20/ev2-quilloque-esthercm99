package es.iessaladillo.pedrojoya.quilloque

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    private val navController: NavController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()
        if (savedInstanceState == null) {
            navigateToStartFragment()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(AppBarConfiguration(navController.graph)) || super.onSupportNavigateUp()
    }

    private fun navigateToStartFragment() = navigateToDial()
    private fun setupViews() = setupBottomNavigationView()

    private fun setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateToOption(it)
            true
        }
    }
    private fun navigateToOption(item: MenuItem) {
        when (item.itemId) {
            R.id.mnuDial -> navigateToDial()
            R.id.mnuRecent -> navigateToRecent()
            R.id.mnuContacts -> navigateToContacts()
        }
    }
    private fun navigateToDial() = navController.navigate(R.id.dialFragment)
    private fun navigateToRecent() = navController.navigate(R.id.recentFragment)
    private fun navigateToContacts() = navController.navigate(R.id.contactsFragment)
}