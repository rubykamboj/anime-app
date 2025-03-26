package com.rubykamboj.anime.data.network.response

import com.rubykamboj.anime.data.network.model.AnimeRemote
import kotlinx.serialization.Serializable

@Serializable
data class TopAnime(
    val pagination: Pagination,
    val data: List<AnimeRemote>,
)
