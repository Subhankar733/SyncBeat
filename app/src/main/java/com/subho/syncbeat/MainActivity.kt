package com.subho.syncbeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.subho.syncbeat.model.PlayerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: PlayerViewModel = viewModel()
                val isPlaying by viewModel.isPlaying.collectAsState()
                
                Scaffold(
                    bottomBar = {
                        BottomPlayerBar(
                            isPlaying = isPlaying,
                            songTitle = "Playing Now",
                            onPlayPauseClick = { viewModel.togglePlayback() }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Text("SyncBeat - মিউজিক প্লেয়ার রেডি!", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun BottomPlayerBar(isPlaying: Boolean, songTitle: String, onPlayPauseClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxWidth().height(70.dp), color = MaterialTheme.colorScheme.surfaceVariant) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = songTitle, modifier = Modifier.weight(1f))
            Button(onClick = onPlayPauseClick) {
                Text(if (isPlaying) "Pause" else "Play")
            }
        }
    }
}
