package com.rubykamboj.anime.data.network.api

import com.rubykamboj.anime.data.network.response.AnimeDetails
import com.rubykamboj.anime.data.network.response.TopAnime

interface AnimeApi {

    suspend fun getTopAnime(): TopAnime

    suspend fun getAnimeDetails(animeId: Int): AnimeDetails
}