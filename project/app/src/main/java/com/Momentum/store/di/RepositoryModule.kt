package com.Momentum.store.di

import com.momentum.data.api.ProductApiService
import com.momentum.data.db.ProductDao
import com.momentum.data.repository.ProductRepositoryImpl
import com.momentum.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providesProductRepository(
        productRemoteDataSource: ProductApiService,
        productLocalDataSource: ProductDao
    ): ProductRepositoryImpl =
        ProductRepositoryImpl(productRemoteDataSource, productLocalDataSource)

}