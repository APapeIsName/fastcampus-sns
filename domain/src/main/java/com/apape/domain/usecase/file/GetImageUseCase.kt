package com.apape.domain.usecase.file

import com.apape.domain.model.Image

interface GetImageUseCase {
    operator fun invoke(contentUri:String): Image?
}