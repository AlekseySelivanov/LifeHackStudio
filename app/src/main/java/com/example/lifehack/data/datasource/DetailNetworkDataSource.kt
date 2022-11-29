package com.example.lifehack.data.datasource

import com.example.lifehack.data.network.DetailApi
import com.example.lifehack.domain.entity.DetailResponseItem
import retrofit2.Response
import javax.inject.Inject

interface DetailNetworkDataSource {
    suspend fun getDataById(id: Int): Response<Array<DetailResponseItem>>
}

class DetailNetworkDataSourceImpl @Inject constructor(
    private val detailApiClient: DetailApi
) : DetailNetworkDataSource {


    override suspend fun getDataById(id: Int): Response<Array<DetailResponseItem>> =
        detailApiClient.getDetailCompany(id)

}