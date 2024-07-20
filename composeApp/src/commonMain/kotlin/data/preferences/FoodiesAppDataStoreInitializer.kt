package data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okio.Path.Companion.toPath

internal const val dataStoreFileName = "meals.preferences_pb"

fun initDataStore(
    producePath: () -> String,
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
    scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() ),
    corruptionHandler = null,
    migrations = emptyList(),
    produceFile = { producePath().toPath() },
)
