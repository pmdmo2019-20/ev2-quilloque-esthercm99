package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.DatabaseContact
import kotlinx.android.synthetic.main.dial_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class DialFragment : Fragment() {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(navHostFragment)
    }
    private val viewmodel: DialFragmentViewmodel by viewModels {
        DialFragmentViewmodelFactory(DatabaseContact.getInstance(this.requireContext()).recentsDao, requireActivity().application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dial_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupKeyboard()
    }

    private fun setupKeyboard() {
        lblOne.setOnClickListener { writeNumber(lblOne.text.toString()) }
        lblTwo.setOnClickListener { writeNumber(lblTwo.text.toString()) }
        lblThree.setOnClickListener { writeNumber(lblThree.text.toString()) }
        lblFour.setOnClickListener { writeNumber(lblFour.text.toString()) }
        lblFive.setOnClickListener { writeNumber(lblFive.text.toString()) }
        lblSix.setOnClickListener { writeNumber(lblSix.text.toString()) }
        lblSeven.setOnClickListener { writeNumber(lblSeven.text.toString()) }
        lblEight.setOnClickListener { writeNumber(lblEight.text.toString()) }
        lblNine.setOnClickListener { writeNumber(lblNine.text.toString()) }
        lblZero.setOnClickListener { writeNumber(lblZero.text.toString()) }
        lblAstherisc.setOnClickListener { writeNumber(lblAstherisc.text.toString()) }
        lblPound.setOnClickListener { writeNumber(lblPound.text.toString()) }

        imgBackspace.setOnClickListener { eraseNumber() }
    }
    private fun writeNumber(number: String) {
        viewmodel.setCurrentNumber(number)
        viewmodel.currentNumber.observe(this) {
            lblNumber.text = it
        }
    }

    private fun eraseNumber() {
        viewmodel.eraseAnNumberOfCurrentNumber()
        viewmodel.currentNumber.observe(this) {
            lblNumber.text = it
        }
    }

}