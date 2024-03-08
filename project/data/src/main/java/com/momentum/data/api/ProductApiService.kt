package com.momentum.data.api

import com.momentum.domain.model.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProductsList(
    ): Response<ArrayList<ProductListItem>>
}