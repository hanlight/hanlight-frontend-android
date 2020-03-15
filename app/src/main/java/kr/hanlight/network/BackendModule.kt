package kr.hanlight.network

import kr.hanlight.network.service.login.LoginService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

var backendModule = module {

    single { HeaderInterceptor(androidContext()) }
    single { RetrofitBuilder.getInstance(androidContext()) }

    /** login */
    factory { get<Retrofit>().create<LoginService>() }
}