package com.rubykamboj.anime.data.network.api

import com.rubykamboj.anime.data.network.response.TopAnime
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AnimeApiImpl(private val client: HttpClient) : AnimeApi {

    companion object {

        private const val BASE_URL = "https://api.jikan.moe/v4"
    }

    override suspend fun getTopAnime(): TopAnime {
        val url = "$BASE_URL/top/anime"
        val response = client.get(url)
        return response.body()
    }

    override suspend fun getAnimeDetails(animeId: Int) {
        val url = "$BASE_URL/anime/$animeId"
    }
}