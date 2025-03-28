package com.rubykamboj.anime.ui.screen.anime.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rubykamboj.anime.ui.component.AppBar
import com.rubykamboj.anime.ui.navigation.LocalNavController
import com.rubykamboj.anime.ui.navigation.Screen

@Composable
fun AnimeDetailsScreen(
    route: Screen.AnimeDetails,
    viewModel: AnimeDetailsViewModel = hiltViewModel(),
) {
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    AnimeDetailsScaffold(
        title = route.animeTitle,
        state = state,
        onBackClick = {
            navController.navigateUp()
        },
    )
}

@Composable
fun AnimeDetailsScaffold(
    title: String,
    state: AnimeDetailsState,
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = title,
                onBackClick = onBackClick,
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            if (state.loading) {
                CircularProgressIndicator()
            }
            state.anime?.let { anime ->
                AnimeDetails(
                    anime = anime,
                    modifier = Modifier.matchParentSize(),
                )
            }
        }
    }
}