package com.subho.syncbeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.subho.syncbeat.player.PlayerManager
import com.subho.syncbeat.ui.MusicScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PlayerManager.init(this)

        setContent {
            MaterialTheme {
                Surface {
                    MusicScreen()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        PlayerManager.release()
    }
}
