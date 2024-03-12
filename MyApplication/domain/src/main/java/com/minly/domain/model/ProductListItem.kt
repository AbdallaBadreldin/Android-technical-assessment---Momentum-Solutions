package com.minly.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Serializable
@Entity
data class ProductListItem(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("category")
    @ColumnInfo("category")
    val category: String?,
    @SerializedName("description")
    @ColumnInfo("description")
    val description: String?,
    @SerializedName("image")
    @ColumnInfo("image")
    val image: String?,
    @SerializedName("price")
    @ColumnInfo("price")
    val price: Double?,
    @SerializedName("rating")
    @ColumnInfo("rating")
    val rating: Rating?,
    @SerializedName("title")
    @ColumnInfo("title")
    val title: String?
) : java.io.Serializable