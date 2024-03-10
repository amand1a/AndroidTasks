package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.NavFragmentBinding

class NavFragment : Fragment(R.layout.nav_fragment) {

    lateinit var binding: NavFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NavFragmentBinding.bind(view)
        init()


    }


    fun init(){
        binding.buttonFirstScreen.setOnClickListener {
            findNavController().navigate(R.id.action_navFragment_to_firstScreen)
        }
        binding.buttonSecondScreen.setOnClickListener {
            findNavController().navigate(R.id.action_navFragment_to_secondScreen)
        }
        binding.buttonThirdScreen.setOnClickListener {
            findNavController().navigate(R.id.action_navFragment_to_thirdScreen)
        }

    }
}