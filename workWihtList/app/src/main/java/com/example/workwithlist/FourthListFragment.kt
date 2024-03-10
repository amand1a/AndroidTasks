package com.example.workwithlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.workwithlist.databinding.FourthListFragmentBinding


class FourthListFragment: Fragment(R.layout.fourth_list_fragment) {
  lateinit var binding: FourthListFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FourthListFragmentBinding.bind(view)

    }

    fun init(){
        binding.apply {

        }
    }
}