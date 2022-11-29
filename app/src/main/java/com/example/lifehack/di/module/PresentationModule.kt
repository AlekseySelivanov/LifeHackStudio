package com.example.lifehack.di.module

import android.content.Context
import com.example.lifehack.domain.usecase.GetDataByIDUseCase
import com.example.lifehack.domain.usecase.GetDataUseCase
import com.example.lifehack.presentation.viewmodel.CompanyViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Singleton
    @Provides
    fun provideCompanyViewModel(
        getDataUseCase: GetDataUseCase,
        getDataByIDUseCase: GetDataByIDUseCase,
        context: Context
    ): CompanyViewModel = CompanyViewModel(
        getDataUseCase,
        getDataByIDUseCase,
        context
    )
}