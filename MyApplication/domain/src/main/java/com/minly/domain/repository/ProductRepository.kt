package com.minly.domain.repository

import com.minly.domain.model.ProductListItem
import com.minly.domain.utils.RequestStatus
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductsFromApi(): Flow<RequestStatus<List<ProductListItem>>>
    suspend fun addProductsToDB(data: List<ProductListItem>)
    fun getProductsFromDB(): List<ProductListItem>
}