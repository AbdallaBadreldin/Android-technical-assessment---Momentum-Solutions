package com.Momentum.store.di

import android.app.Application
import com.momentum.data.db.ProductDB
import com.momentum.data.db.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)object DataBaseModule {
    @Provides
    fun provideDatabase(app: Application): ProductDao =
        ProductDB.getInstance(app).productDatabaseDao()

}