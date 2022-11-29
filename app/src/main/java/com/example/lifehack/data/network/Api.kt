package com.example.lifehack.data.network

import com.example.lifehack.domain.entity.DetailResponseItem
import com.example.lifehack.domain.entity.ResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("v2/top-headlines")
    suspend fun getCompany(
    ): Response<Array<ResponseItem>>

}

interface DetailApi {
    @GET("v2/top-headlines")
    suspend fun getDetailCompany(
        @Query("id")
        id: Int = 1
    ): Response<Array<DetailResponseItem>>
}
