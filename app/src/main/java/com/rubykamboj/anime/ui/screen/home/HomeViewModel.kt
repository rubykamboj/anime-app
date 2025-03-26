package com.rubykamboj.anime.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rubykamboj.anime.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getAnime()
    }

    private fun getAnime() {
        viewModelScope.launch {
            animeRepository.getAnime()
                .onSuccess { anime ->
                    _state.update {
                        it.copy(
                            loading = false,
                            anime = anime,
                        )
                    }
                }
                .onFailure { exception ->
                    _state.update {
                        it.copy(
                            loading = false,
                            error = exception.message,
                        )
                    }
                }
        }
    }
}