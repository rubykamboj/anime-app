package com.rubykamboj.anime.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    @SerialName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
)
