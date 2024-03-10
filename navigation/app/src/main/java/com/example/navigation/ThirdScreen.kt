package com.example.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.databinding.ThirdFragmentBinding



class ThirdScreen: Fragment(R.layout.third_fragment) {
    lateinit var binding: ThirdFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ThirdFragmentBinding.bind(view)
        init()
    }

    fun init(){
        binding.buttonRaiseAlpha.setOnClickListener{
            binding.imageView.setAlpha(binding.imageView.alpha + 0.1f)

        }
        binding.buttonLowerAlpha.setOnClickListener{
            binding.imageView.setAlpha(binding.imageView.alpha - 0.1f)

        }
    }
}