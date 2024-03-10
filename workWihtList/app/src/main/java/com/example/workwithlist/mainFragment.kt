package com.example.workwithlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController

import com.example.workwithlist.databinding.MainFragmentBinding

class mainFragment : Fragment(R.layout.main_fragment) {

    lateinit var binding: MainFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        val navController = (childFragmentManager.findFragmentById(R.id.fragmentContainerView1) as NavHostFragment).navController
        init(navController)
    }

    fun init(navController: NavController){
        binding.apply {
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}