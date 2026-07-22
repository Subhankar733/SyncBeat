package com.subho.syncbeat.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.subho.syncbeat.model.Song

object PlayerManager {

    private var player: ExoPlayer? = null

    var currentSong: Song? = null
        private set

    fun init(context: Context) {
        if (player == null) {
            player = ExoPlayer.Builder(context.applicationContext).build()
        }
    }

    fun play(song: Song) {
        currentSong = song

        player?.apply {
            setMediaItem(MediaItem.fromUri(song.uri))
            prepare()
            play()
        }
    }

    fun pause() {
        player?.pause()
    }

    fun resume() {
        player?.play()
    }

    fun togglePlayPause() {
        player?.let {
            if (it.isPlaying) {
                it.pause()
            } else {
                it.play()
            }
        }
    }

    fun stop() {
        player?.stop()
    }

    fun release() {
        player?.release()
        player = null
    }

    fun isPlaying(): Boolean = player?.isPlaying ?: false
}
