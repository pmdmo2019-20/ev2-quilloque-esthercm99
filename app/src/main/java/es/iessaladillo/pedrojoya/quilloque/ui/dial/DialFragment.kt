package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.CALL_TYPE_MADE
import es.iessaladillo.pedrojoya.quilloque.data.CALL_TYPE_VIDEO
import es.iessaladillo.pedrojoya.quilloque.data.DatabaseContact
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentCall
import kotlinx.android.synthetic.main.dial_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class DialFragment : Fragment() {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(navHostFragment)
    }
    private val viewmodel: DialFragmentViewmodel by viewModels {
        DialFragmentViewmodelFactory(DatabaseContact.getInstance(this.requireContext()).recentsDao, requireActivity().application)
    }

    private lateinit var dialAdapter: DialFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dial_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
        setupRecyclerView()
        setupKeyboard()
    }

    private fun setupKeyboard() {

        lblCreateContact.setOnClickListener { navigateToCreateContact() }

        viewmodel.currentNumber.observe(this) {
            if(it.isNullOrEmpty()) {
                imgVideo.visibility = View.INVISIBLE
                imgBackspace.visibility = View.INVISIBLE
            } else {
                imgVideo.visibility = View.VISIBLE
                imgBackspace.visibility = View.VISIBLE
            }
        }

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

        fabCall.setOnClickListener { call(CALL_TYPE_MADE) }
        imgVideo.setOnClickListener { call(CALL_TYPE_VIDEO) }
    }

    private fun navigateToCreateContact() = navController.navigate(R.id.addContactFragment)

    private fun writeNumber(number: String) {
        viewmodel.setCurrentNumber(number)
        viewmodel.currentNumber.observe(this) {
            lblNumber.text = it
        }
        submitRecentCalls()
    }
    private fun eraseNumber() {
        viewmodel.eraseAnNumberOfCurrentNumber()
        viewmodel.currentNumber.observe(this) {
            lblNumber.text = it
        }
        submitRecentCalls()
    }

    private fun call(type: String) = viewmodel.callNumber(type)

    private fun setupAdapter() {
        dialAdapter = DialFragmentAdapter().also {
            it.onItemClickListener = { position -> call("call") }
        }
    }
    private fun setupRecyclerView() {
        lstSuggestions.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 1)
            adapter = dialAdapter
        }
    }

    private fun submitRecentCalls() {
        viewmodel.submitSuggestionsCall()
        viewmodel.suggestionsContacts.observe(this) {
            showCalls(it)
        }
        // Listener
    }
    private fun showCalls(callsList: List<RecentCall>) {
        lstSuggestions.post {
            dialAdapter.submitList(callsList)
            lstSuggestions.visibility = if (callsList.isNotEmpty()) View.VISIBLE else View.INVISIBLE
            lblCreateContact.visibility = if (callsList.isEmpty()) View.VISIBLE else View.INVISIBLE
        }
    }

}