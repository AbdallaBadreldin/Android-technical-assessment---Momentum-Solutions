package com.momentum.domain.repository

import com.momentum.domain.model.ProductListItem
import com.momentum.domain.utils.RequestStatus
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductsFromApi(): Flow<RequestStatus<List<ProductListItem>>>
    suspend fun addProductsToDB(data: List<ProductListItem>)
    fun getProductsFromDB(): List<ProductListItem>
}