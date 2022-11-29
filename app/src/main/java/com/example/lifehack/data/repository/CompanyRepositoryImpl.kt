package com.example.lifehack.data.repository

import com.example.lifehack.data.datasource.DetailNetworkDataSource
import com.example.lifehack.data.datasource.NetworkCompanyDataSource
import com.example.lifehack.domain.entity.DetailResponseItem
import com.example.lifehack.domain.entity.ResponseItem
import com.example.lifehack.domain.repository.CompanyRepository
import retrofit2.Response
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(
    private val networkCompanyDataSource: NetworkCompanyDataSource,
    private val detailNetworkDataSource: DetailNetworkDataSource
) : CompanyRepository {

    override suspend fun getListCompany(): Response<Array<ResponseItem>> =
        networkCompanyDataSource.getData()

    override suspend fun getCompanyById(id: Int): Response<Array<DetailResponseItem>> =
        detailNetworkDataSource.getDataById(id)

}