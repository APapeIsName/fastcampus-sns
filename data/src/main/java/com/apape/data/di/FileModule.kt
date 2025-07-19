package com.apape.data.di

import com.apape.data.usecase.file.GetImageUseCaseImpl
import com.apape.data.usecase.file.GetInputStreamUseCaseImpl
import com.apape.data.usecase.file.UploadImageUseCaseImpl
import com.apape.domain.usecase.file.GetImageUseCase
import com.apape.domain.usecase.file.GetInputStreamUseCase
import com.apape.domain.usecase.file.UploadImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

    @Binds
    abstract fun bindGetInputStreamUseCase(uc: GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCase(uc: GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uc: UploadImageUseCaseImpl): UploadImageUseCase
}