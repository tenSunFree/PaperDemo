package com.example.paperdemo.common.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val themePreferenceKey = intPreferencesKey("list_theme")

fun Context.isDarkThemeOn() = dataStore.data
    .map { preferences ->
        preferences[themePreferenceKey] ?: 0
    }
