package com.example.alpha.domain

import android.util.Log
import com.example.alpha.data.ContentRepository
import com.example.alpha.data.models.ResultsDto
import com.example.alpha.entity.ResultsInterface
import retrofit2.Response
import javax.inject.Inject

class GetContentUseCase @Inject constructor(

    private val contentRepository: ContentRepository
) {
    suspend fun execute(): ResultsInterface? {

        val req: Response<ResultsDto> =
            contentRepository.searchIPI.getContent()
        var contentFromJson: ResultsInterface? = null
        if (req.isSuccessful) {
            contentFromJson = req.body()
            Log.d("@2@", "${contentFromJson?.results?.get(0)?.subsection}")
        }
        return contentFromJson
    }
}