package com.rubykamboj.anime.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeRemote(
    @SerialName("mal_id")
    val id: Int,
    val images: AnimeImages,
    val title: String,
    @SerialName("title_english")
    val titleEnglish: String?,
    val episodes: Int,
    val rating: String,
)