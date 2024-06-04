package com.foodies.project

import android.app.Application
import org.koin.core.context.startKoin
import injection.modules

class FoodiesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            modules(modules)
        }
    }
}