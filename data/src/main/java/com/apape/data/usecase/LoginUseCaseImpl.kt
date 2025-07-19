package com.apape.data.usecase

import com.apape.data.model.LoginParam
import com.apape.data.retrofit.UserService
import com.apape.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService,
) : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> = runCatching {
        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}