package com.rubykamboj.anime.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeImage(
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("small_image_url")
    val smallImageUrl: String,
    @SerialName("large_image_url")
    val largeImageUrl: String,
    @SerialName("medium_image_url")
    val mediumImageUrl: String? = null,
    @SerialName("maximum_image_url")
    val maximumImageUrl: String? = null,
)
