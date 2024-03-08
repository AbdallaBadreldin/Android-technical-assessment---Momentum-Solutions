package com.Momentum.store.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momentum.domain.model.ProductListItem
import com.momentum.domain.userCase.GetProductListUseCase
import com.momentum.domain.utils.RequestStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getProducts: GetProductListUseCase) :
    ViewModel() {
    private val _isLoad = MutableLiveData<Boolean>().apply { value = false }
    private val _product = MutableLiveData<ArrayList<ProductListItem>>()
    private val _error = MutableLiveData<String>()
    val isLoad: LiveData<Boolean> get() = _isLoad
    val product: LiveData<ArrayList<ProductListItem>> get() = _product
    val error: LiveData<String> get() = _error

    fun getProducts() {
        Log.e("TAG","works fine")
        viewModelScope.launch {
            getProducts.invoke().collect { requestStatus ->
                when (requestStatus) {
                    is RequestStatus.Success -> {
                        _product.postValue(requestStatus.data!! as ArrayList<ProductListItem>?)
                        _isLoad.postValue(false)
                    }

                    is RequestStatus.Error -> {
                        _error.postValue(requestStatus.message)
                        _isLoad.postValue(false)
                    }

                    is RequestStatus.Waiting -> {
                        _isLoad.postValue(true)
                    }
                }
            }
        }
    }
}