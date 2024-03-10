package com.example.workwithlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.workwithlist.adapters.FirstAdapter
import com.example.workwithlist.data.generateUsers
import com.example.workwithlist.databinding.FirstListFragmnetBinding

class FirstListFragment : Fragment(R.layout.first_list_fragmnet) {

    lateinit var binding: FirstListFragmnetBinding
    val adapter: FirstAdapter = FirstAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirstListFragmnetBinding.bind(view)
        init()
    }

    fun init(){
        binding.apply {
            RecyclerViewFirstFragment.adapter = adapter
            RecyclerViewFirstFragment.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , true)
            adapter.addElem(generateUsers())
        }
    }
}