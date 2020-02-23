package kr.hanlight

import android.app.Application
import kr.network.backendModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class HanlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HanlightApplication)

            androidLogger()

            module { listOf(backendModule) }
        }
    }
}