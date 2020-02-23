package kr.network

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

var backendModule = module {
    single { RetrofitBuilder.getInstance(androidContext()) }

}