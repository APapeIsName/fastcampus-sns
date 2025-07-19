package com.apape.data.usecase

import com.apape.data.UserDataStore
import com.apape.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
): GetTokenUseCase {

    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}