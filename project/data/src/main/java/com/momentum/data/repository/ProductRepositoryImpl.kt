package com.momentum.data.repository

import com.momentum.data.api.ProductApiService
import com.momentum.data.db.ProductDao
import com.momentum.domain.model.ProductListItem
import com.momentum.domain.repository.ProductRepository
import com.momentum.domain.utils.RequestStatus
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductApiService,
    private val productLocalDataSource: ProductDao
) : ProductRepository {

    override suspend fun getProductsFromApi() = flow {
        emit(RequestStatus.Waiting)
        try {
            val response: Response<ArrayList<ProductListItem>> =
                productRemoteDataSource.getProductsList()

            if (response.isSuccessful) {
                emit(RequestStatus.Success(response.body()!!))
                addProductsToDB(response.body()!!)
            } else {
                emit(RequestStatus.Success(getProductsFromDB()))
            }
        } catch (e: Exception) {
            emit(RequestStatus.Error(e.message ?: "An error occurred"))
        }
    }

    override fun getProductsFromDB(): ArrayList<ProductListItem> {
        return productLocalDataSource.getAllProducts()
    }

    override suspend fun addProductsToDB(data: ArrayList<ProductListItem>) {
        return productLocalDataSource.addProducts(data)
    }
}