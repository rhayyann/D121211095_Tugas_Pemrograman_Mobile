package com.d121211095.quotable.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.d121211095.quotable.data.repository.QuotableRepository
import com.d121211095.quotable.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val quotableRepository: QuotableRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api.quotable.io"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val quotableRepository: QuotableRepository
        get() = QuotableRepository(retrofitService)

}