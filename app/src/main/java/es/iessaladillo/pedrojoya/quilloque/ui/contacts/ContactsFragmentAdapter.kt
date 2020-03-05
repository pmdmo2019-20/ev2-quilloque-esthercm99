package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import es.iessaladillo.pedrojoya.quilloque.utils.createAvatarDrawable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.contacts_fragment_item.*

class ContactsFragmentAdapter () : RecyclerView.Adapter<ContactsFragmentAdapter.ViewHolder>() {
    var dataList: List<Contact> = mutableListOf()
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.contacts_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    fun submitList(newList : List<Contact>){
        dataList = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        init { containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) } }
        fun bind(contact: Contact) {
            contact.run {
                lblName.text = name
                lblPhoneNumber.text = phoneNumber
                imgAvatar.setImageDrawable(createAvatarDrawable(lblName.text.toString()))
            }
        }
    }
}