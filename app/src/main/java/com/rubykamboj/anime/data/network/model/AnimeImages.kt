package com.rubykamboj.anime.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AnimeImages(
    val jpg: AnimeImage,
    val webp: AnimeImage,
)
