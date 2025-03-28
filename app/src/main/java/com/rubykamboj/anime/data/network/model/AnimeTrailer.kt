package com.rubykamboj.anime.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeTrailer(
    @SerialName("youtube_id")
    val youtubeId: String?,
    val url: String?,
    @SerialName("embed_url")
    val embedUrl: String?,
)
