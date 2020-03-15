package kr.hanlight

import android.app.Application
import kr.hanlight.login.loginModule
import kr.hanlight.network.backendModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HanlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HanlightApplication)

            androidLogger()

            modules(listOf(loginModule, backendModule))
        }
    }
}