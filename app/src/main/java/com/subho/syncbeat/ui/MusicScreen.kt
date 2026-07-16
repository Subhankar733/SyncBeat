package com.subho.syncbeat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.subho.syncbeat.data.MusicRepository

@Composable
fun MusicScreen() {
    val context = LocalContext.current
    val songs = remember { MusicRepository.getSongs(context) }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "🎵 SyncBeat",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(songs) { song ->
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(song.title)
                    Text(
                        song.artist,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
