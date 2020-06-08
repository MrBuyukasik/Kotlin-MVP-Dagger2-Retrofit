package com.example.dagger2example.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2example.R
import com.example.dagger2example.models.PostViewModel

class ListAdapter(
    private val context: Context,
    private val list: MutableList<PostViewModel>,
    fragment: Fragment
) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val listener: ListAdapter.onItemClickListener

    init {
        this.listener = fragment as ListAdapter.onItemClickListener
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var post = list[position]

        // holder!!.bind(post)
        holder.title!!.setText(post.title)
        holder.body!!.setText(post.body)

        holder.layout!!.setOnClickListener {
            listener.itemDetail(post.id.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ListAdapter.ListViewHolder(itemView)
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout = itemView.findViewById<ConstraintLayout>(R.id.item_layout)
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val body = itemView.findViewById<TextView>(R.id.item_body)

        fun bind(item: PostViewModel) {
            // title = item.post
            // body etc.
        }
    }

    interface onItemClickListener {
        fun itemRemoveClick(post: PostViewModel)
        fun itemDetail(postId: String)
    }
}