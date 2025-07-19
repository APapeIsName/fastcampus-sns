package com.apape.domain.usecase.file

import com.apape.domain.model.Image

interface UploadImageUseCase {
    suspend operator fun invoke(
        image: Image
    ): Result<String>
}