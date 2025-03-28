package com.rubykamboj.anime.util

import com.rubykamboj.anime.data.model.Anime
import com.rubykamboj.anime.data.network.model.AnimeRemote

fun AnimeRemote.toAnime(): Anime {
    return Anime(
        id = id,
        posterUrl = images.webp.imageUrl,
        title = titleEnglish ?: title,
        episodes = episodes,
        rating = rating,
        youtubeId = trailer?.youtubeId,
        synopsis = synopsis.trim(),
        genres = genres,
    )
}