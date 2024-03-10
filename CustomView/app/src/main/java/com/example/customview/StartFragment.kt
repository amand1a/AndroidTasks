package com.example.customview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.customview.databinding.StartFragmentBinding
import kotlin.random.Random

class StartFragment: Fragment(R.layout.start_fragment) {

    lateinit var binding: StartFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = StartFragmentBinding.bind(view)
        binding.button2.setOnClickListener {
            val randNum = Random.nextInt(0 , 101)
            binding.customBar.setValue(randNum.toFloat())
        }
    }
}