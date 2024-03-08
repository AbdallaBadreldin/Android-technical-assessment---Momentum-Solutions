package com.Momentum.store.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.Momentum.store.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setDataOnScreen()
        return binding.root

    }

    private fun setDataOnScreen() {
        val item = args.productItem
        Glide.with(this)
            .load(item.image)
            .apply(
                RequestOptions()
                    .error(com.google.android.material.R.drawable.mtrl_ic_error)
            )
            .into(binding.imageView)

        binding.tvProductTitle.text = item.title
        binding.tvProductDesc.text = item.description
        binding.ratingBar.rating = (item.rating?.rate?.toFloat() ?: 0) as Float
        binding.tvProductPrice.text = item.price.toString()
    }


}