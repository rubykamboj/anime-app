package com.rubykamboj.anime.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object Home : Screen()

    @Serializable
    data class AnimeDetails(val animeId: Int, val animeTitle: String) : Screen()
}