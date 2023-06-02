package com.arthlimchiu.rottenbanana.core.work.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkerParameters
import com.arthlimchiu.rottenbanana.core.common.Dispatcher
import com.arthlimchiu.rottenbanana.core.common.MyDispatchers.IO
import com.arthlimchiu.rottenbanana.core.data.movies.MoviesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

@HiltWorker
class AppStartupWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    private val moviesRepository: MoviesRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result = withContext(ioDispatcher) {
        awaitAll(
            async { moviesRepository.fetchNowPlayingMovies() },
            async { moviesRepository.fetchPopularMovies() },
            async { moviesRepository.fetchTopRatedMovies() },
            async { moviesRepository.fetchUpcomingMovies() }
        )
        Result.success()
    }

    companion object {
        fun startStartupWork() = OneTimeWorkRequestBuilder<DelegatingWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .setInputData(AppStartupWorker::class.delegatedData())
            .build()
    }
}