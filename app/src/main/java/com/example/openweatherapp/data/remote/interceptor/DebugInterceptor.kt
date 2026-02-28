package com.example.openweatherapp.data.remote.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class DebugInterceptor : Interceptor {
    //Don't use in production
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()

        request.body?.let {
            val buffer = okio.Buffer()
            it.writeTo(buffer)
            Log.d("Network Debug", "Request full Url: $url")
            Log.d("Network Debug", "Request Body: ${buffer.readUtf8()}")
        }

        return chain.proceed(request)
    }
}