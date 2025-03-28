package com.rubykamboj.anime.ui.screen.anime.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.rubykamboj.anime.data.repository.AnimeRepository
import com.rubykamboj.anime.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val animeRepository: AnimeRepository,
) : ViewModel() {

    private val route = savedStateHandle.toRoute<Screen.AnimeDetails>()

    private val _state = MutableStateFlow(AnimeDetailsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            animeRepository.getAnimeDetails(route.animeId)
                .onSuccess { anime ->
                    _state.update {
                        it.copy(
                            loading = false,
                            anime = anime,
                        )
                    }
                }
                .onFailure {
                    _state.update {
                        it.copy(loading = false)
                    }
                }
        }
    }
}