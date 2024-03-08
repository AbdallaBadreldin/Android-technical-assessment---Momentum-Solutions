package com.momentum.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.momentum.domain.model.ProductListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<ProductListItem>)

    @Query("SELECT * FROM productlistitem")
    fun getAllProducts(): List<ProductListItem>

    // TODO ("CAUTION")
    //dangerous command PLEASE use it carefully xD Just kidding
    @Query("DELETE FROM productlistitem")
    suspend fun deleteAllProducts()
}