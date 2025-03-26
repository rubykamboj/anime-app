package com.rubykamboj.anime.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationItems(
    val count: Int,
    val total: Int,
    @SerialName("per_page")
    val perPage: Int,
)
