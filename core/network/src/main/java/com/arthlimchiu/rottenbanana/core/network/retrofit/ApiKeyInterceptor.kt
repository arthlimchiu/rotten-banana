package com.arthlimchiu.rottenbanana.core.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZmQyNjFiNDA4MmZkMzZiYjczZTUzOTgyMjdiZGU0ZCIsInN1YiI6IjU3YjQwMDNmOTI1MTQxMjZiNDAwMzFlMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t3NoraOk9iUJYKEPT0AUD9ZuNL94JqSejw7NQZfXBG4")
            .build()

        return chain.proceed(request)
    }
}