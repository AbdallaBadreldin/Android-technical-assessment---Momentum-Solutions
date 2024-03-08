package com.Momentum.store.presentation

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.Momentum.store.databinding.FragmentMainBinding
import com.momentum.domain.model.ProductListItem
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.ViewModelLifecycle

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setUpObservers()
        viewModel.getProducts()
        return binding.root
    }

    private fun setUpObservers() {
        viewModel.isLoad.observe(viewLifecycleOwner) {
            //should show loading progressbar or use paging
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
        }
        viewModel.product.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty())
                setUiNoData(true)
            else {
                setUiNoData(false)
                setupProductsAdapter(it)
            }
        }
    }

    private fun setupProductsAdapter(list: ArrayList<ProductListItem>) {
        val adapter = ProductsAdapter(list) { item ->
            goToProductDetails(item)
        }
        binding.productList.layoutManager = LinearLayoutManager(context)
        binding.productList.adapter = adapter
    }

    private fun goToProductDetails(item: ProductListItem) {
//      findNavController().navigate(FragmentD.)
    }

    private fun setUiNoData(flag: Boolean) {
        if (flag) {
            binding.productList.visibility = View.GONE
            binding.noData.visibility = View.VISIBLE
        } else {
            binding.productList.visibility = View.VISIBLE
            binding.noData.visibility = View.GONE
        }
    }


}