package com.foodies.project

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.source.local.FoodiesAppDatabase

fun getAppDatabase(context: Context): FoodiesAppDatabase {
    val databaseFile = context.getDatabasePath("foodies_app.db")
    return Room.databaseBuilder<FoodiesAppDatabase>(
        context = context.applicationContext,
        name = databaseFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}
