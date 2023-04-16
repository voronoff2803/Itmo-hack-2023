package ru.ok.android.itmohack2023.pixels

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class PixelsBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action

        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE == action) {
            Log.d("PixelsBroadcastReceiver", "DOWNLOAD DONE")

            val size = DownloadManager.COLUMN_TOTAL_SIZE_BYTES

            Log.d("PixelsBroadcastReceiver", "DOWNLOAD ${size}")
        }


    }
}