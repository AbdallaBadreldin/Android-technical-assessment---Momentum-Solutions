package com.Momentum.store.di

import com.momentum.data.repository.ProductRepositoryImpl
import com.momentum.domain.userCase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetProductUseCase(
        repo: ProductRepositoryImpl
    ): GetProductListUseCase {
        return GetProductListUseCase(repo)
    }
}