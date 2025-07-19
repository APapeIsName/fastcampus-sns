package com.apape.domain.usecase.login

interface SetTokenUseCase {

    suspend operator fun invoke(token: String)
}