package com.example.capstoneproject.data.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")
class UserPreference(private val dataStore: DataStore<Preferences>) {

    suspend fun saveSession(username: String){
        dataStore.edit { preferences->
            preferences[USERNAME_KEY] = username
        }
    }

    suspend fun getSession(): String?{
       return dataStore.data.first()[USERNAME_KEY]
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null
        private val USERNAME_KEY = stringPreferencesKey("username")
        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}