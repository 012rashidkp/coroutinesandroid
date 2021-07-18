package com.example.hiltdagger.Model

import com.google.gson.annotations.SerializedName

data class RecyclerData(
    @SerializedName("name")
    val  name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("owner")
    val owner: Owner?
)
