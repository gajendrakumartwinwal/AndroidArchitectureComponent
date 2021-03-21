package com.arch.app.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arch.app.R


class ViewRepository {
    fun getView(viewGroup: ViewGroup, type: Int): View {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_view, viewGroup, false)
        return view
    }
}