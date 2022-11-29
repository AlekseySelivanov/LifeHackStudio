package com.example.lifehack.di.module

import com.example.lifehack.domain.usecase.GetDataUseCase
import com.example.lifehack.domain.repository.CompanyRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideGetDataUseCase(
        companyRepository: CompanyRepository
    ): GetDataUseCase = GetDataUseCase(companyRepository)
}