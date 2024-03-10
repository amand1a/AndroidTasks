package com.example.navigation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.navigation.databinding.FirstFragmentBinding

class FirstScreen : Fragment(R.layout.first_fragment) {
    
    lateinit var binding: FirstFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirstFragmentBinding.bind(view)
        
        init()
    }
    
    
    
    fun init(){
        binding.buttonShowText.setOnClickListener{
            binding.imageView.isVisible = false
            binding.textUpImage.isVisible = true
        }
        binding.buttonShowImage.setOnClickListener {
            binding.imageView.isVisible = true
            binding.textUpImage.isVisible = false
        }
        binding.textUpImage.isVisible = false
    }
}