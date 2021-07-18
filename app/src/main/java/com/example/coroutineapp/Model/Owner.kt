package com.example.hiltdagger.Model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val avatar_url: String?
)
