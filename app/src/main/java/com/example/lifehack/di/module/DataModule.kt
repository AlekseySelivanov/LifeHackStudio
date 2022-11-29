package com.example.lifehack.di.module

import com.example.lifehack.data.datasource.NetworkCompanyDataSourceImpl
import com.example.lifehack.data.datasource.NetworkCompanyDataSource
import com.example.lifehack.data.network.Api
import com.example.lifehack.data.network.Constants.BASE_URL
import com.example.lifehack.data.network.DetailApi
import com.example.lifehack.data.datasource.DetailNetworkDataSource
import com.example.lifehack.data.datasource.DetailNetworkDataSourceImpl
import com.example.lifehack.data.repository.CompanyRepositoryImpl
import com.example.lifehack.domain.repository.CompanyRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideCompanyRepository(
        networkCompanyDataSource: NetworkCompanyDataSource,
        detailNetworkDataSource: DetailNetworkDataSource
    ): CompanyRepository =
        CompanyRepositoryImpl(networkCompanyDataSource, detailNetworkDataSource)

    @Singleton
    @Provides
    fun provideNetworkDataSource(api: Api): NetworkCompanyDataSource =
        NetworkCompanyDataSourceImpl(api)

    @Singleton
    @Provides
    fun provideSingleNetworkDataSource(detailApi: DetailApi): DetailNetworkDataSource =
        DetailNetworkDataSourceImpl(detailApi)


    @Singleton
    @Provides
    fun provideSingleCompanyApiClient(): DetailApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(DetailApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCompanyApiClient(): Api {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(Api::class.java)
    }

}