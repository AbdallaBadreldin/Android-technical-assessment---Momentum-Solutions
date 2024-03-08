package com.Momentum.store.di

import android.content.Context
import androidx.room.Room
import com.Momentum.store.util.Constants
import com.bumptech.glide.load.model.ByteArrayLoader.Converter
import com.momentum.data.api.ProductApiService
import com.momentum.data.db.ProductDB
import com.momentum.data.db.ProductDao
import com.momentum.data.db.ProductTypeConverter
import com.momentum.data.repository.ProductRepositoryImpl
import com.momentum.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, ProductDB::class.java, "productdatabase").addTypeConverter(ProductTypeConverter())
            .allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideProductsDao(db: ProductDB) = db.productsDao()

}