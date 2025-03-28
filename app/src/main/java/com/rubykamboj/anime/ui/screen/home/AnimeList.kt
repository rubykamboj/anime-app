package com.rubykamboj.anime.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.rubykamboj.anime.R
import com.rubykamboj.anime.data.model.Anime
import com.rubykamboj.anime.ui.theme.AppTheme

@Composable
fun AnimeCard(
    data: Anime,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clickable(
                onClick = onClick,
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AsyncImage(
            model = data.posterUrl,
            contentDescription = data.title,
            modifier = Modifier.width(96.dp),
            onState = {
                when (it) {
                    is AsyncImagePainter.State.Error -> {
                        it.result.throwable.printStackTrace()
                    }
                    else -> Unit
                }
            },
            contentScale = ContentScale.FillWidth,
        )
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(
                modifier = Modifier.size(4.dp),
            )
            Text(
                text = data.rating,
                style = MaterialTheme.typography.labelMedium,
            )
            Spacer(
                modifier = Modifier.size(8.dp),
            )
            Text(
                text = stringResource(R.string.n_episodes, data.episodes),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
fun AnimeList(
    data: List<Anime>,
    onItemClick: (Anime) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            vertical = 8.dp
        ),
    ) {
        items(
            items = data,
            key = { it.id },
        ) { anime ->
            AnimeCard(
                data = anime,
                onClick = {
                    onItemClick(anime)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimeListPrev() {
    val data = remember {
        listOf(
            Anime(
                id = 1,
                posterUrl = "",
                title = "Frieren: Beyond Journey's End",
                episodes = 28,
                rating = "PG-13 - Teens 13 or older",
                youtubeId = null,
                synopsis = "",
                genres = emptyList(),
            ),
            Anime(
                id = 2,
                posterUrl = "",
                title = "Fullmetal Alchemist: Brotherhood",
                episodes = 64,
                rating = "R - 17+ (violence & profanity)",
                youtubeId = null,
                synopsis = "",
                genres = emptyList(),
            ),
        )
    }
    AppTheme {
        AnimeList(
            data = data,
            onItemClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}