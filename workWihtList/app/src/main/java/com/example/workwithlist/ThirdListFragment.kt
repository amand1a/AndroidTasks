package com.example.workwithlist

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.workwithlist.adapters.ThirdAdapter
import com.example.workwithlist.data.generateMedicalCard
import com.example.workwithlist.databinding.ThirdListFragmentBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch


class ThirdListFragment : Fragment(R.layout.third_list_fragment) {

  lateinit var binding: ThirdListFragmentBinding
  private val adapter: ThirdAdapter = ThirdAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ThirdListFragmentBinding.bind(view)
        init()

    }

    fun init(){
        binding.apply {
            RecyclerViewThird.adapter = adapter
            RecyclerViewThird.layoutManager = GridLayoutManager(context , 2 , GridLayoutManager.VERTICAL ,false )
            adapter.addItems(generateMedicalCard())
        }
    }


}