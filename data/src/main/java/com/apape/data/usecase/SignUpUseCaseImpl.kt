package com.apape.data.usecase

import com.apape.data.model.SignUpParam
import com.apape.data.retrofit.UserService
import com.apape.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {
    override suspend fun invoke(id: String, userName: String, password: String): Result<Boolean> = runCatching{
        val requestBody =
        SignUpParam(
            loginId = id,
            name = userName,
            password = password,
            extraUserInfo = "",
            profileFilePath = "",
        ).toRequestBody()
        userService.signUp(requestBody = requestBody).result == "SUCCESS"
    }
}