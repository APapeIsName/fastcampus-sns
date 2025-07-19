package com.apape.data.usecase

import com.apape.data.UserDataStore
import com.apape.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : SetTokenUseCase {

    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }
}