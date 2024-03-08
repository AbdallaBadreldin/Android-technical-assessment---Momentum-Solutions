package com.momentum.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "products")
data class ProductListItem(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("rating")
    val rating: Rating?,
    @SerializedName("title")
    val title: String?
) : Serializable