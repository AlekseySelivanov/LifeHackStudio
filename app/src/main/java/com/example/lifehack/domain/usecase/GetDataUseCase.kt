package com.example.lifehack.domain.usecase

import com.example.lifehack.domain.entity.ResponseItem
import com.example.lifehack.domain.repository.CompanyRepository
import retrofit2.Response
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val companyRepository: CompanyRepository) {
    suspend operator fun invoke(): Response<Array<ResponseItem>> =
        companyRepository.getListCompany()
}
