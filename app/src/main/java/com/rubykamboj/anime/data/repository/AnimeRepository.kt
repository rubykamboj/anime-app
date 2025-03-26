package com.rubykamboj.anime.data.repository

import android.util.Log
import com.rubykamboj.anime.data.model.Anime
import com.rubykamboj.anime.data.network.api.AnimeApi
import com.rubykamboj.anime.util.toAnime
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api: AnimeApi
) {

    companion object {

        private const val TAG = "AnimeRepository"
    }

    suspend fun getAnime(): Result<List<Anime>> {
        return try {
            val response = api.getTopAnime()
            val anime = response.data.map { it.toAnime() }
            Result.success(anime)
        } catch (e: Exception) {
            Log.e(TAG, "getAnime: ", e)
            Result.failure(e)
        }
    }
}