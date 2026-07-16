package com.subho.syncbeat.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.subho.syncbeat.data.MusicRepository
import com.subho.syncbeat.model.Song
import com.subho.syncbeat.player.PlayerManager

@Composable
fun MusicScreen() {

    val context = LocalContext.current
    val songs = remember {
        MusicRepository.getSongs(context)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "🎵 SyncBeat",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(songs) { song ->
                SongItem(song)
            }
        }
    }
}

@Composable
private fun SongItem(song: Song) {

    Column(
        modifier = Modifier
            .clickable {
                PlayerManager.play(song)
            }
            .padding(16.dp)
    ) {

        Text(
            text = song.title,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = song.artist,
            style = MaterialTheme.typography.bodyMedium
        )

        Divider(modifier = Modifier.padding(top = 12.dp))
    }
}
