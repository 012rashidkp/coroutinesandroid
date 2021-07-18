package com.example.coroutineapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineapp.Adapter.RecyclerViewAdapter
import com.example.coroutineapp.R
import com.example.coroutineapp.ViewModel.MainActivityViewModel
import com.example.hiltdagger.Model.RecyclerData
import com.example.hiltdagger.Model.RecyclerList
import java.util.Observer


class RecyclerListFragment : Fragment() {
    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)

        initViewModel(view)
        initViewModel()
        return view

    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion  = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter


    }

    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if(it != null) {
                recyclerAdapter.setUpdatedData(it.items as ArrayList<RecyclerData>)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}