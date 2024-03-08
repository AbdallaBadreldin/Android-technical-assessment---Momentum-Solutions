package com.Momentum.store.di

import android.content.Context
import androidx.room.Room
import com.momentum.data.db.ProductDB
import com.momentum.data.db.ProductTypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, ProductDB::class.java, "productdatabase")
            .addTypeConverter(ProductTypeConverter())
            .allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideProductsDao(db: ProductDB) = db.productsDao()

}