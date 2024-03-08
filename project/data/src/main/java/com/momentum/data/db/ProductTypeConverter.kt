package com.momentum.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.momentum.domain.model.Rating
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class ProductTypeConverter {

    @TypeConverter
    fun fromRatingToString(productListItem: Rating): String {
        return Json.encodeToString(productListItem)
    }

    @TypeConverter
    fun toRatingFromString(json: String): Rating {
        return Json.decodeFromString(json)
    }

}