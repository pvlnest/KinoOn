package com.pvl.nest.kinoon

import android.app.Application
import com.pvl.nest.kinoon.di.appModule
import com.pvl.nest.kinoon.di.navModule
import com.pvl.nest.kinoon.di.videoPlayerModule
import com.pvl.nest.kinoon.feature.movies_screen.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CiOnApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@CiOnApp)
            modules(
                appModule, navModule, moviesModule,
                videoPlayerModule
            )
        }
    }
}