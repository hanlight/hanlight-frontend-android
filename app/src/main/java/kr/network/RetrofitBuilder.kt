package kr.network

import android.content.Context
import io.reactivex.schedulers.Schedulers
import kr.hanlight.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private const val BASE_URL = "https://test-backend.hanlight.kr/api/dev/"

    fun getInstance(context: Context): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()

        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(BASE_URL)
            .client(okHttpBuilder.build())
            .build()
    }
}