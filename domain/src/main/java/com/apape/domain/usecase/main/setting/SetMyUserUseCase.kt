package com.apape.domain.usecase.main.setting

interface SetMyUserUseCase {

    suspend operator fun invoke(
        userName: String? = null,
        profileImageUrl: String? = null
    ):Result<Unit>
}