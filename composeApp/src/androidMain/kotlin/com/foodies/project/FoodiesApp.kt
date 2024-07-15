package com.foodies.project

import android.app.Application
import injection.modules
import org.koin.core.context.startKoin

class FoodiesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(modules)
        }
    }
}
