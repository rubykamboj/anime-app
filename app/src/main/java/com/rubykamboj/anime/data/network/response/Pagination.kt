package com.rubykamboj.anime.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    @SerialName("last_visible_page")
    val lastVisiblePage: Int,
    @SerialName("has_next_page")
    val hasNextPage: Boolean,
    @SerialName("current_page")
    val currentPage: Int,
    val items: PaginationItems,
)
