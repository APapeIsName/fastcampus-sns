package com.apape.domain.usecase.login

interface GetTokenUseCase {

    suspend operator fun invoke(): String?
}