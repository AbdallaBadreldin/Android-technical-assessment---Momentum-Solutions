package com.momentum.data.db

import androidx.room.TypeConverter
import com.momentum.domain.model.ProductListItem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductTypeConverter {
    @TypeConverter
    fun fromProductListToString(productListItem: List<ProductListItem>): String {
        return Json.encodeToString(productListItem)
    }

    @TypeConverter
    fun toProductListFromString(json: String): List<ProductListItem> {
        return Json.decodeFromString(json)
    }

}