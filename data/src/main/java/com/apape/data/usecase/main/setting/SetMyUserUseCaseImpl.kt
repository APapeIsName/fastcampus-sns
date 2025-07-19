package com.apape.data.usecase.main.setting

import com.apape.data.model.UpdateMyInfoParam
import com.apape.data.retrofit.UserService
import com.apape.domain.usecase.main.setting.GetMyUserUseCase
import com.apape.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        userName: String?,
        profileImageUrl: String?
    ): Result<Unit> = runCatching {
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = userName?:user.userName,
            profileFilePath = profileImageUrl?:user.profileImageUrl.orEmpty(),
            extraUserInfo = "",
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}