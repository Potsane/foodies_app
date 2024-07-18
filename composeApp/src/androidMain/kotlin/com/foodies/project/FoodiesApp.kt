package com.foodies.project

import android.app.Application
import injection.modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class FoodiesApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@FoodiesApp)
            modules(modules)
        }
    }
}
