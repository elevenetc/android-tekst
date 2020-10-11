package com.elevenetc.tekst

import android.app.Application
import com.elevenetc.tekst.flags.FlagsManager
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        val appModule = module {
            single { FlagsManager() }
        }

        startKoin {
            modules(appModule)
        }
    }
}