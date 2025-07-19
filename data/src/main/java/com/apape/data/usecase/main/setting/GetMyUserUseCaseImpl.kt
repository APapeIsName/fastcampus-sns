package com.apape.data.usecase.main.setting

import com.apape.data.model.toDomainModel
import com.apape.data.retrofit.UserService
import com.apape.domain.model.User
import com.apape.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {

    override suspend fun invoke(): Result<User> = runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}