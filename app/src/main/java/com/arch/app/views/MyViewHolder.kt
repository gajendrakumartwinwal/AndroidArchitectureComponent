package com.arch.app.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arch.app.R
import com.arch.app.data.FeedItem

class MyViewHolder : RecyclerView.ViewHolder {
    lateinit var textview: TextView

    //@atul what is the difference doubt
    constructor(itemView: View) : super(itemView) {
        textview = itemView.findViewById(R.id.tv_item_headline)
    }

    fun bind(feedItem: FeedItem) {
        textview.setText(feedItem.name)
    }
}