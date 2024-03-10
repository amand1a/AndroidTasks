package com.example.workwithlist

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.workwithlist.adapters.FirstAdapter
import com.example.workwithlist.data.User
import com.example.workwithlist.databinding.FifthListFragmentBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FifthListFragment: Fragment(R.layout.fifth_list_fragment) {
  val viewModel: FifthViewModel by viewModels()

    lateinit var binding: FifthListFragmentBinding
    private val adapter =  FirstAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getFristsListUsers()
        Log.d("fifthList" , "create")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FifthListFragmentBinding.bind(view)
        init()
        initObservers()
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewState.collect {
                updateUi(it.users, it.fetchingTypeInfo)
            }
        }
    }

    fun init(){
        binding.apply {
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.refreshUser()
            }
            floatingActionButtonDeleteAll.setOnClickListener{
                viewModel.deleteUsers()
            }
            swipeRefreshLayout.isRefreshing = true
        }

    }

    fun updateUi(users: ArrayList<User>  , fetState: FetchingTypeInfo){
        when(fetState){
            FetchingTypeInfo.Fetching -> {
                binding.apply {
                    swipeRefreshLayout.isRefreshing = true
                    RecyclerViewFifth.visibility = View.GONE
                    textViewEmptyList.visibility = View.GONE
                    progressBar2.visibility = View.GONE
                }
            }

            FetchingTypeInfo.Error -> {
                binding.apply {
                adapter.deleteAll()
                    swipeRefreshLayout.isRefreshing = false
                RecyclerViewFifth.visibility = View.VISIBLE
                textViewEmptyList.visibility = View.VISIBLE
                progressBar2.visibility = View.GONE}
            }
            FetchingTypeInfo.Success -> {
                binding.apply {
                    RecyclerViewFifth.visibility = View.VISIBLE
                    swipeRefreshLayout.isRefreshing = false
                    RecyclerViewFifth.adapter = adapter
                    RecyclerViewFifth.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , true)
                    adapter.addElem(users)
                    textViewEmptyList.visibility = View.GONE
                    progressBar2.visibility = View.GONE
                }
            }
        }


    }
}