package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentCall
import es.iessaladillo.pedrojoya.quilloque.utils.createAvatarDrawable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dial_fragment_item.*
import kotlinx.android.synthetic.main.dial_fragment_item.imgAvatar
import kotlinx.android.synthetic.main.dial_fragment_item.lblPhoneNumber
import kotlinx.android.synthetic.main.recent_fragment_item.*

class DialFragmentAdapter () : RecyclerView.Adapter<DialFragmentAdapter.ViewHolder>() {
    var dataList: List<RecentCall> = mutableListOf()
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.dial_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    fun submitList(newList : List<RecentCall>){
        dataList = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        init { containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) } }
        fun bind(recentCall: RecentCall) {
            recentCall.run {
                if (contactName.isNullOrEmpty()) {
                    lblContactName.text = phoneNumber
                    imgAvatar.setImageDrawable(createAvatarDrawable("?"))
                } else {
                    lblContactName.text = contactName
                    imgAvatar.setImageDrawable(createAvatarDrawable(lblName.text.toString()))
                }

                lblPhoneNumber.text = phoneNumber
            }
        }
    }
}
