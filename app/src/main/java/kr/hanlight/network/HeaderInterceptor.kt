package kr.hanlight.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val context: Context
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request()
            .newBuilder()
            .addHeader("access_token", "") // UserPreference 필요
            .build()
            .let { chain.proceed(it) }
    }
}