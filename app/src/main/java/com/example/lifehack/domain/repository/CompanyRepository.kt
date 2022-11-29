package com.example.lifehack.domain.repository

import com.example.lifehack.domain.entity.DetailResponseItem
import com.example.lifehack.domain.entity.ResponseItem
import retrofit2.Response

interface CompanyRepository {
    suspend fun getListCompany(): Response<Array<ResponseItem>>

    suspend fun getCompanyById(id: Int): Response<Array<DetailResponseItem>>
}