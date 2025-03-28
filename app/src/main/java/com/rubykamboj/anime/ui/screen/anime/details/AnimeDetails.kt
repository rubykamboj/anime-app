package com.rubykamboj.anime.ui.screen.anime.details

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.rubykamboj.anime.R
import com.rubykamboj.anime.data.model.Anime

@Composable
fun AnimeDetails(
    anime: Anime,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
) {
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(16.dp),
    ) {
        anime.youtubeId?.let {
            YouTubePlayer(
                videoId = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
            )
            Spacer(
                modifier = Modifier.size(16.dp),
            )
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AsyncImage(
                model = anime.posterUrl,
                contentDescription = anime.title,
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
                    text = anime.title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(
                    modifier = Modifier.size(4.dp),
                )
                Text(
                    text = anime.rating,
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(
                    modifier = Modifier.size(8.dp),
                )
                Text(
                    text = stringResource(R.string.n_episodes, anime.episodes),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
        Spacer(
            modifier = Modifier.size(16.dp),
        )
        Text(
            text = stringResource(R.string.genre),
            style = MaterialTheme.typography.labelSmall,
        )
        Spacer(
            modifier = Modifier.size(4.dp),
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(anime.genres) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = MaterialTheme.shapes.small,
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp,
                        ),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
        Spacer(
            modifier = Modifier.size(16.dp),
        )
        Text(
            text = stringResource(R.string.plot),
            style = MaterialTheme.typography.labelSmall,
        )
        Spacer(
            modifier = Modifier.size(4.dp),
        )
        Text(
            text = anime.synopsis,
        )
    }
}