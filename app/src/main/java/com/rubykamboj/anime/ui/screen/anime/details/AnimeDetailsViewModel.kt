package com.rubykamboj.anime.ui.screen.anime.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rubykamboj.anime.data.repository.AnimeRepository
import com.rubykamboj.anime.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val animeRepository: AnimeRepository,
) : ViewModel() {

    private val route = savedStateHandle.toRoute<Screen.AnimeDetails>()

    init {
        Log.d("TAG", "route: ${route.animeId}")
    }
}