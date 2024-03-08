package com.Momentum.store.presentation

import androidx.lifecycle.ViewModel
import com.momentum.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: ProductRepository) : ViewModel() {

}