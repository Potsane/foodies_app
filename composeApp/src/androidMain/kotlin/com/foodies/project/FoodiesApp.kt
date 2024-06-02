package com.foodies.project

import android.app.Application
import org.koin.core.context.startKoin

class FoodiesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        //init all the app modules on here
        startKoin {
            modules()
        }
    }
}