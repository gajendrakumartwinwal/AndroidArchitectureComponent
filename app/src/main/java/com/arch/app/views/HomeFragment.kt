package com.arch.app.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arch.app.R
import com.arch.app.viewmodel.FeedViewModel

class HomeFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var myAdapter: MyAdapter;
    lateinit var feedViewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.home_fragemnt, container, false)
        recyclerView = view.findViewById(R.id.rvHome)
        progressBar = view.findViewById(R.id.pbRecycler)
        initView()
        return view;
    }

    private fun initView() {
        myAdapter = MyAdapter()
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        subscribeUi()

        feedViewModel.fetchData()
    }

    fun subscribeUi() {
        feedViewModel.feedLiveData.observe(this, Observer { data ->
            run {
                if (data == null || data.size == 0) {
                    recyclerView.visibility = View.GONE
                    progressBar.visibility = View.VISIBLE
                } else {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    myAdapter.setData(data)
                }
            }
        })
    }
}