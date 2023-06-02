package com.arthlimchiu.rottenbanana.core.network.di

import com.arthlimchiu.rottenbanana.core.network.AppNetworkDataSource
import com.arthlimchiu.rottenbanana.core.network.BuildConfig
import com.arthlimchiu.rottenbanana.core.network.retrofit.ApiKeyInterceptor
import com.arthlimchiu.rottenbanana.core.network.retrofit.RetrofitAppNetwork
import com.arthlimchiu.rottenbanana.core.network.retrofit.TmdbApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesJson(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun providesOkHttpClient(apiKeyInterceptor: ApiKeyInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(apiKeyInterceptor)
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                    )
                }
            }
            .build()
    }

    @Provides
    @Singleton
    fun providesTmdbApi(okHttpClient: OkHttpClient, json: Json): TmdbApi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(TmdbApi::class.java)
    }

    @Provides
    @Singleton
    fun providesAppNetworkDataSource(api: TmdbApi): AppNetworkDataSource {
        return RetrofitAppNetwork(api)
    }
}