package com.d121211095.quotable.data.source.remote

import com.d121211095.quotable.data.response.GetQuotesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("quotes?limit=1000")
    suspend fun getQuotes(
    ): GetQuotesResponse

}