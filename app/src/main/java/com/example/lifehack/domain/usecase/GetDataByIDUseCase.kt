package com.example.lifehack.domain.usecase

import com.example.lifehack.domain.entity.DetailResponseItem
import com.example.lifehack.domain.repository.CompanyRepository
import retrofit2.Response
import javax.inject.Inject

class GetDataByIDUseCase @Inject constructor(private val companyRepository: CompanyRepository) {
    suspend operator fun invoke(id: Int): Response<Array<DetailResponseItem>> =
        companyRepository.getCompanyById(id)
}