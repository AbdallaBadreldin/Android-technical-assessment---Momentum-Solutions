package com.momentum.domain.model


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Rating(
    @SerializedName("count")
    @ColumnInfo("count")
    val count: Int?,
    @SerializedName("rate")
    @ColumnInfo("rate")
    val rate: Double?
)