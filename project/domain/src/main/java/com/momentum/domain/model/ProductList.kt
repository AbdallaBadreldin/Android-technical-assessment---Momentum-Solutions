package com.momentum.domain.model


import androidx.room.Entity
import java.io.Serializable
class ProductList : ArrayList<ProductListItem>(), Serializable
