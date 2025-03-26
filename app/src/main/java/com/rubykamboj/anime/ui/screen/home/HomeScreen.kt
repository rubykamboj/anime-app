package com.rubykamboj.anime.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rubykamboj.anime.R
import com.rubykamboj.anime.ui.component.AppBar
import com.rubykamboj.anime.ui.navigation.LocalNavController
import com.rubykamboj.anime.ui.navigation.Screen
import com.rubykamboj.anime.ui.theme.AppTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScaffold(
        state = state,
        onEvent = {
            when (it) {
                is HomeEvent.AnimeClicked -> {
                    navController.navigate(
                        Screen.AnimeDetails(
                            animeId = it.item.id,
                            animeTitle = it.item.title,
                        )
                    )
                }
            }
        },
    )
}

@Composable
fun HomeScaffold(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.app_name),
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            when {
                state.loading -> {
                    CircularProgressIndicator()
                }
                state.anime.isNotEmpty() -> {
                    AnimeList(
                        data = state.anime,
                        onItemClick = {
                            onEvent(HomeEvent.AnimeClicked(it))
                        },
                        modifier = Modifier.matchParentSize(),
                    )
                }
                state.error != null -> {
                    Text(text = state.error)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScaffoldPrev() {
    AppTheme {
        HomeScaffold(
            state = HomeState(),
            onEvent = {},
        )
    }
}