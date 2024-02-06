package com.example.alpha.data

import com.example.alpha.data.models.ResultsDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Inject

class ContentRepository @Inject constructor() {

    companion object {
        private const val BASE_API = "https://api.nytimes.com/svc/topstories/v2/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchIPI: SearchAPI = retrofit.create(SearchAPI::class.java)

    interface SearchAPI {
        @Headers(
            "Accept: application/json",
            "Content-type: application/json"
        )
        @GET(
            "arts.json?api-key=RLAiANGjNJqIUe6wH7kHVukJY2S4joGz"
        )
        suspend fun getContent(): Response<ResultsDto>
    }

}