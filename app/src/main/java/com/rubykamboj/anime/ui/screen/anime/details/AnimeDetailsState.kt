package com.rubykamboj.anime.ui.screen.anime.details

import com.rubykamboj.anime.data.model.Anime

data class AnimeDetailsState(
    val loading: Boolean = true,
    val anime: Anime? = null,
    val error: String? = null,
)
