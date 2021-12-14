package com.pvl.nest.kinoon.base.constants

object Constants {
    // API
    const val BASE_MOVIES_URL = "https://api.npoint.io/"
    const val BASE_MOVIES_PATH = "05b0bfc9ef4453cf7af3"
    // Cache
    const val CACHE_SIZE_10_MB = 50L * 1024 * 1024
    const val CACHE_CONTROL_HEADER = "Cache-Control"
    const val CACHE_CONTROL_NO_CACHE = "no-cache"
    // Delays
    const val DEFAULT_THROTTLE_DELAY = 200L
    // Player Service
    const val PLAYER_NOTIFICATION_ID = 1
    const val PLAYER_SERVICE_TAG = "PLAYER_SERVICE_TAG"
    const val MEDIA_FILE = "video"
    const val MEDIA_ROOT_ID = "MEDIA_ROOT_ID"
    const val NETWORK_ERROR = "NETWORK_ERROR"
}