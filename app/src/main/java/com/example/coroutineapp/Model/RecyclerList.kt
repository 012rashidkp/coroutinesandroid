package com.example.hiltdagger.Model

import com.google.gson.annotations.SerializedName

data class RecyclerList(
    @SerializedName("items")
    val items: List<RecyclerData>
)
