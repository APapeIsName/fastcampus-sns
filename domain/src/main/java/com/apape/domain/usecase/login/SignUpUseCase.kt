package com.apape.domain.usecase.login

interface SignUpUseCase {

    suspend operator fun invoke(id: String, userName: String, password: String):Result<Boolean>
}