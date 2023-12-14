package com.d121211095.quotable.data.model.quote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Quote(
    @SerialName("_id")
    val _id: String,
    @SerialName("author")
    val author: String,
    @SerialName("authorSlug")
    val authorSlug: String,
    @SerialName("content")
    val content: String,
    @SerialName("dateAdded")
    val dateAdded: String,
    @SerialName("dateModified")
    val dateModified: String,
    @SerialName("length")
    val length: Int,
    @SerialName("tags")
    val tags: List<String>
): Parcelable