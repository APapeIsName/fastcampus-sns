package com.apape.data.di

import com.apape.data.retrofit.FCInterceptor
import com.apape.data.retrofit.FileService
import com.apape.data.retrofit.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

val FC_HOST = "http://172.30.1.26:8080"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideOkHttpClient(interceptor: FCInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor = interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val converterFactory = Json{
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json; charset=UTF8".toMediaType())
        return Retrofit.Builder()
            .baseUrl("${FC_HOST}/api/")
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun provideFileService(retrofit: Retrofit): FileService {
        return retrofit.create(FileService::class.java)
    }
}