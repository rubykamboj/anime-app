package com.rubykamboj.anime.ui.screen.home

import com.rubykamboj.anime.data.model.Anime

data class HomeState(
    val loading: Boolean = true,
    val anime: List<Anime> = emptyList(),
    val error: String? = null,
)