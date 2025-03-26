package com.rubykamboj.anime.ui.screen.home

import com.rubykamboj.anime.data.model.Anime

sealed class HomeEvent {

    data class AnimeClicked(val item: Anime) : HomeEvent()
}