package com.pvl.nest.kinoon.player.listeners

import android.app.Notification
import android.content.Intent
import androidx.core.content.ContextCompat
import com.pvl.nest.kinoon.base.constants.Constants.PLAYER_NOTIFICATION_ID
import com.pvl.nest.kinoon.player.PlayerVideoService
import com.google.android.exoplayer2.ui.PlayerNotificationManager

class PlayerNotificationListener(
    private val playerVideoService: PlayerVideoService
) : PlayerNotificationManager.NotificationListener {
    override fun onNotificationCancelled(notificationId: Int, dismissedByUser: Boolean) {
        super.onNotificationCancelled(notificationId, dismissedByUser)
        playerVideoService.apply {
            stopForeground(true)
            isForegroundService = false
            stopSelf()
        }
    }

    override fun onNotificationPosted(
        notificationId: Int,
        notification: Notification,
        ongoing: Boolean
    ) {
        super.onNotificationPosted(notificationId, notification, ongoing)
        playerVideoService.apply {
            if (ongoing && !isForegroundService) {
                ContextCompat.startForegroundService(
                    this,
                    Intent(applicationContext, this::class.java)
                )
                startForeground(PLAYER_NOTIFICATION_ID, notification)
                isForegroundService = true
            }
        }
    }
}