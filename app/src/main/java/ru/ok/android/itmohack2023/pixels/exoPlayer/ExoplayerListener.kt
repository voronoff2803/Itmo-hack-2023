package ru.ok.android.itmohack2023.pixels.exoPlayer;

import android.util.Log
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData

public class ExoplayerListener : AnalyticsListener {
        override fun onLoadStarted(
                eventTime: AnalyticsListener.EventTime,
                loadEventInfo: LoadEventInfo,
                mediaLoadData: MediaLoadData
        ) {
                Log.d("Exoplayer Request", "EXO Player Start")
        }

        override fun onLoadCompleted(
                eventTime: AnalyticsListener.EventTime,
                loadEventInfo: LoadEventInfo,
                mediaLoadData: MediaLoadData
        ) {
                Log.d("Exoplayer Request", "Url: ${loadEventInfo.uri.toString()}")
                Log.d("Exoplayer Request", "Size: ${loadEventInfo.bytesLoaded}")
        }
}