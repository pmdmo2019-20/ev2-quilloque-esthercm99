package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.getCallTypeIcon
import es.iessaladillo.pedrojoya.quilloque.data.pojo.ContactCall
import es.iessaladillo.pedrojoya.quilloque.utils.createAvatarDrawable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recent_fragment_item.*

class RecentFragmentAdapter () : RecyclerView.Adapter<RecentFragmentAdapter.ViewHolder>() {
    var dataList: List<ContactCall> = mutableListOf()
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recent_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    fun submitList(newList: List<ContactCall>) {
        dataList = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        init {
            containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) }
        }

        fun bind(contactCall: ContactCall) {

            contactCall.run {
                if (contactName.isNullOrEmpty()) {
                    lblName.text = phoneNumber
                    imgAvatar.setImageDrawable(createAvatarDrawable("?"))
                    btnCall.visibility = View.INVISIBLE
                    btnDelete.visibility = View.INVISIBLE
                    btnMessage.visibility = View.INVISIBLE
                    btnVideoCall.visibility = View.INVISIBLE
                    lblPhoneNumber.visibility = View.INVISIBLE
                    lblCreateContact.visibility = View.VISIBLE
                } else {
                    lblName.text = contactName
                    lblPhoneNumber.text = phoneNumber
                    imgAvatar.setImageDrawable(createAvatarDrawable(lblName.text.toString()))
                    btnCall.visibility = View.VISIBLE
                    btnDelete.visibility = View.VISIBLE
                    btnMessage.visibility = View.VISIBLE
                    btnVideoCall.visibility = View.VISIBLE
                    lblPhoneNumber.visibility = View.VISIBLE
                    lblCreateContact.visibility = View.INVISIBLE
                }

                imgCallType.setImageResource(getCallTypeIcon(type))
                lblDate.text = date
                lblTime.text = time

            }
        }
    }
}