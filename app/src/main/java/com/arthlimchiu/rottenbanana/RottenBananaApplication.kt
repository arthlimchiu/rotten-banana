package com.arthlimchiu.rottenbanana

import android.app.Application
import com.arthlimchiu.rottenbanana.core.work.initializers.AppStartupInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RottenBananaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppStartupInitializer.initialize(this)
    }
}