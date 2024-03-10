package com.example.workwithlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.workwithlist.adapters.SecondAdapter
import com.example.workwithlist.data.generateUsers
import com.example.workwithlist.databinding.SecondListFragmentBinding


class SecondListFragment: Fragment(R.layout.second_list_fragment) {

    lateinit var  binding : SecondListFragmentBinding
    private val  adapter = SecondAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SecondListFragmentBinding.bind(view)
        init()
    }


    fun init(){
        binding.apply {
            RecuclerViewSecond.adapter = adapter
            RecuclerViewSecond.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
            adapter.addEleaddElems(generateUsers())
        }
    }
}