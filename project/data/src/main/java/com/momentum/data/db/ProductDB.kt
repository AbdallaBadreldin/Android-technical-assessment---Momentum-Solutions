package com.momentum.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.momentum.domain.model.ProductListItem

@Database(entities = [ProductListItem::class], version = 2, exportSchema = false)
@TypeConverters(ProductTypeConverter::class)
abstract class ProductDB : RoomDatabase() {
    abstract fun productsDao(): ProductDao
}