package com.apape.data.usecase

import com.apape.data.UserDataStore
import com.apape.domain.usecase.login.ClearTokenUseCase
import com.apape.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : ClearTokenUseCase {

    override suspend fun invoke(): Result<Unit> = runCatching{
        userDataStore.clear()
    }
}