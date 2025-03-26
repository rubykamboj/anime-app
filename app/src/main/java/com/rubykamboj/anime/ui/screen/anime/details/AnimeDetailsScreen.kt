package com.rubykamboj.anime.ui.screen.anime.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rubykamboj.anime.ui.component.AppBar
import com.rubykamboj.anime.ui.navigation.Screen

@Composable
fun AnimeDetailsScreen(
    route: Screen.AnimeDetails,
    viewModel: AnimeDetailsViewModel = hiltViewModel(),
) {
    AnimeDetailsScaffold(
        title = route.animeTitle,
    )
}

@Composable
fun AnimeDetailsScaffold(title: String) {
    Scaffold(
        topBar = {
            AppBar(title)
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {}
    }
}