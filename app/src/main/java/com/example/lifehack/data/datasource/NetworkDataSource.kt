package com.example.lifehack.data.datasource

import com.example.lifehack.data.network.Api
import com.example.lifehack.domain.entity.ResponseItem
import retrofit2.Response
import javax.inject.Inject

interface NetworkCompanyDataSource {
    suspend fun getData(): Response<Array<ResponseItem>>

}

class NetworkCompanyDataSourceImpl @Inject constructor(
    private val newsNewsApiClient: Api
) : NetworkCompanyDataSource {


    override suspend fun getData(): Response<Array<ResponseItem>> =
        newsNewsApiClient.getCompany()

}
