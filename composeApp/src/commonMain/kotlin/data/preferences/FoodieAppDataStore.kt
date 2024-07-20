package data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface FoodieAppDataStore {
    suspend fun updateDataPersistenceTime(time: Long)
    suspend fun getDataPersistenceTime(): Flow<Long>
}

class FoodieAppDataStoreImpl(private val dataStore: DataStore<Preferences>) : FoodieAppDataStore {
    private val tagKey = longPreferencesKey("tag")

    override suspend fun updateDataPersistenceTime(time: Long) {
        dataStore.edit { preferences ->
            preferences[tagKey] = time
        }
    }

    override suspend fun getDataPersistenceTime() = dataStore.data.map { preferences ->
        preferences[tagKey] ?: 0
    }
}