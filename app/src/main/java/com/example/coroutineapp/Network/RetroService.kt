package com.example.coroutineapp.Network

import com.example.hiltdagger.Model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query : String): RecyclerList
}