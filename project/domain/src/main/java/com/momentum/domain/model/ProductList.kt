package com.momentum.domain.model


import androidx.room.Entity
import java.io.Serializable
@Entity(tableName = "products")
class ProductList : ArrayList<ProductListItem>(), Serializable
