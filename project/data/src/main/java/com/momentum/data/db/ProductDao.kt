package com.momentum.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.momentum.domain.model.ProductList
import com.momentum.domain.model.ProductListItem
import kotlinx.coroutines.flow.Flow
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: ArrayList<ProductListItem>)

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<ArrayList<ProductListItem>>

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getProductById(productId: Int): Flow<ProductListItem>

    // TODO ("CAUTION")
    //dangerous command PLEASE use it carefully xD Just kidding
    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()
}