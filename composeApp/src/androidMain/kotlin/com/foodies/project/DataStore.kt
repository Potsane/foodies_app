package com.foodies.project

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.preferences.initDataStore
import data.preferences.dataStoreFileName

fun createDataStore(context: Context): DataStore<Preferences> {
    return initDataStore(
        producePath = {
            context.filesDir.resolve(dataStoreFileName).absolutePath
        }
    )
}
