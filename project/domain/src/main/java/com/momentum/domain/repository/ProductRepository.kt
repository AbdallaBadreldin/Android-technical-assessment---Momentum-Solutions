package com.momentum.domain.repository

import com.momentum.domain.model.ProductList
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
        fun getProductsFromApi(): Flow<ProductList>
        fun getProductsFromDB(): Flow<ProductList>
}