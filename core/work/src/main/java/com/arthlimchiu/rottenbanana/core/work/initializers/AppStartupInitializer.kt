package com.arthlimchiu.rottenbanana.core.work.initializers

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.arthlimchiu.rottenbanana.core.work.workers.AppStartupWorker

object AppStartupInitializer {

    fun initialize(context: Context) {
        WorkManager.getInstance(context).apply {
            enqueueUniqueWork(
                "AppStartupWork",
                ExistingWorkPolicy.KEEP,
                AppStartupWorker.startStartupWork()
            )
        }
    }
}