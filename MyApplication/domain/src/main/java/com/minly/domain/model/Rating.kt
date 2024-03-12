package com.minly.domain.model


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@kotlinx.serialization.Serializable
data class Rating(
    @SerializedName("count")
    @ColumnInfo("count")
    val count: Int?,
    @SerializedName("rate")
    @ColumnInfo("rate")
    val rate: Double?
) : Serializable