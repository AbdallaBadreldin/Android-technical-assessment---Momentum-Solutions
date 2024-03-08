package com.momentum.domain.repository

import com.momentum.domain.model.ProductList
import com.momentum.domain.model.ProductListItem
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
        fun getProductsFromApi(): Flow<ArrayList<ProductListItem>>
        fun getProductsFromDB(): Flow<ArrayList<ProductListItem>>
}