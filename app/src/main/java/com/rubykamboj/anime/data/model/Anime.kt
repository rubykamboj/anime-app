package com.rubykamboj.anime.data.model

import com.rubykamboj.anime.data.network.model.Genre

data class Anime(
    val id: Int,
    val posterUrl: String,
    val title: String,
    val episodes: Int,
    val rating: String,
    val youtubeId: String?,
    val synopsis: String,
    val genres: List<Genre>,
)