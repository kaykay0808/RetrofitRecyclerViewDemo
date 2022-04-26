package com.kay.retrofitrecyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kay.retrofitrecyclerviewdemo.data.MyDataItem
import com.kay.retrofitrecyclerviewdemo.databinding.FragmentListBinding
import com.kay.retrofitrecyclerviewdemo.ui.adapter.MyAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

// "https://jsonplaceholder.typicode.com/"

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by viewModel()
    private val adapter: MyAdapter by lazy { MyAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Get the function from viewModel
        viewModel.getInfo()

        // Recyclerview setup
        setupRecyclerView()

        // observing data
        viewModel.livedata.observe(viewLifecycleOwner, {setupDataList(it)})
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            binding.recyclerviewUser.isVisible = it == null
        }
    }

    private fun setupRecyclerView() {
        val recyclerview = binding.recyclerviewUser
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupDataList(data: List<MyDataItem>) {
        adapter.setData(data)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
