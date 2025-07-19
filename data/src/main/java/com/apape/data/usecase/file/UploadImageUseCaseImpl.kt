package com.apape.data.usecase.file

import com.apape.data.retrofit.FileService
import com.apape.data.retrofit.UriRequestBody
import com.apape.domain.model.Image
import com.apape.domain.usecase.file.GetInputStreamUseCase
import com.apape.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCaseImpl @Inject constructor(
    private val fileService: FileService,
    private val getInputStreamUseCase: GetInputStreamUseCase
) : UploadImageUseCase {
    override suspend fun invoke(image: Image): Result<String> = runCatching {
        val fileNamePart = MultipartBody.Part.createFormData("fileName", image.name)
        val requestBody = UriRequestBody(
            contentUri = image.uri,
            getInputStreamUseCase = getInputStreamUseCase,
            contentType = image.mimeType.toMediaType(),
            contentLength = image.size
        )
        val filePart = MultipartBody.Part.createFormData("file", image.name, requestBody)
        fileService.uploadFile(
            fileName = fileNamePart,
            file = filePart,
        ).data.filePath
    }
}