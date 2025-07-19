package com.apape.data.di

import com.apape.data.usecase.ClearTokenUseCaseImpl
import com.apape.data.usecase.GetTokenUseCaseImpl
import com.apape.data.usecase.LoginUseCaseImpl
import com.apape.data.usecase.SetTokenUseCaseImpl
import com.apape.data.usecase.SignUpUseCaseImpl
import com.apape.data.usecase.main.setting.GetMyUserUseCaseImpl
import com.apape.data.usecase.main.setting.SetMyUserUseCaseImpl
import com.apape.data.usecase.main.setting.SetProfileImageUseCaseImpl
import com.apape.domain.usecase.login.ClearTokenUseCase
import com.apape.domain.usecase.login.GetTokenUseCase
import com.apape.domain.usecase.login.LoginUseCase
import com.apape.domain.usecase.login.SetTokenUseCase
import com.apape.domain.usecase.login.SignUpUseCase
import com.apape.domain.usecase.main.setting.GetMyUserUseCase
import com.apape.domain.usecase.main.setting.SetMyUserUseCase
import com.apape.domain.usecase.main.setting.SetProfileImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun bindGetMyUserUseCase(uc: GetMyUserUseCaseImpl): GetMyUserUseCase

    @Binds
    abstract fun bindUpdateMyNameUseCase(uc: SetMyUserUseCaseImpl): SetMyUserUseCase

    @Binds
    abstract fun bindSetProfileImageUseCase(uc: SetProfileImageUseCaseImpl): SetProfileImageUseCase
}