package com.momentum.data.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.momentum.domain.model.ProductListItem

@Database(entities = [ProductListItem::class], version = 1)
@TypeConverters(ProductTypeConverter::class)
abstract class ProductDB : RoomDatabase() {
    abstract fun productDatabaseDao(): ProductDao

    companion object {
        private val DATABASE_NAME = "PRODUCT_DATABASE"

        @Volatile
        private var instance: ProductDB? = null
        fun getInstance(context: Context): ProductDB {
            return instance ?: synchronized(this) {
                instance ?: builderDatabase(context).also { instance = it }
            }
        }

        private fun builderDatabase(context: Context): ProductDB {
            return Room.databaseBuilder(context, ProductDB::class.java, DATABASE_NAME).build()
        }
    }
}