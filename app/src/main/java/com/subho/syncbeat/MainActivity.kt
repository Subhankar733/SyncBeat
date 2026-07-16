package com.subho.syncbeat

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.content.ContextCompat
import com.subho.syncbeat.ui.theme.SyncBeatTheme

class MainActivity : ComponentActivity() {

    private val permissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            loadApp()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_MEDIA_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionLauncher.launch(
                    Manifest.permission.READ_MEDIA_AUDIO
                )
            } else {
                loadApp()
            }
        } else {
            loadApp()
        }
    }

    private fun loadApp() {
        setContent {
            SyncBeatTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicScreen()
                }
            }
        }
    }
}
