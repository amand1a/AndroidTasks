package com.example.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.databinding.NavFragmentBinding
import com.example.navigation.databinding.SecondFragmentBinding

class SecondScreen : Fragment(R.layout.second_fragment) {
    lateinit var binding: SecondFragmentBinding

    private val ImageAdapter = ImageAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SecondFragmentBinding.bind(view)

        init()

    }

    fun init(){
        binding.apply {
            RecyclerViewImageCard.adapter = ImageAdapter
            RecyclerViewImageCard.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false )
            ImageAdapter.addImage(Image(R.drawable.clooney))
            buttonAddImage.setOnClickListener {
                ImageAdapter.addImage(Image(R.drawable.clooney))

            }

            buttonRemoveImage.setOnClickListener {
                ImageAdapter.deleteImage()
            }

        }
    }
}