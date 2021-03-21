package com.arch.app.views

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.app.data.FeedItem

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var items: List<FeedItem> = ArrayList()

    fun setData(items: List<FeedItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(ViewRepository().getView(parent, viewType))
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(this.items[position])
    }
}