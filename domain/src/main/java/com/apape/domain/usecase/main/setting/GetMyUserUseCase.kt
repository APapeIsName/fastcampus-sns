package com.apape.domain.usecase.main.setting

import com.apape.domain.model.User

interface GetMyUserUseCase {

    suspend operator fun invoke(): Result<User>
}