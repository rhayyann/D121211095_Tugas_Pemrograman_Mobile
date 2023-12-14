package com.d121211095.quotable.data.response

import com.d121211095.quotable.data.model.quote.Quote
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetQuotesResponse(
    @SerialName("count")
    val count: Int?,
    @SerialName("lastItemIndex")
    val lastItemIndex: Int?,
    @SerialName("page")
    val page: Int?,
    @SerialName("results")
    val results: List<Quote>?,
    @SerialName("totalCount")
    val totalCount: Int?,
    @SerialName("totalPages")
    val totalPages: Int?
)