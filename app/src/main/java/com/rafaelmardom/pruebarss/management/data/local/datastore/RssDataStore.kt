package com.rafaelmardom.pruebarss.management.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "rss_datastore"
)

class RssDataStore (private val context: Context){

    private val gson = Gson()

    suspend fun save(website:String , url: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(url)] = gson.toJson(DomainRss(website, url), DomainRss::class.java)
        }
    }

    fun getAll(): Flow<List<DomainRss>> {
        return context.dataStore.data
            .map {
                it.asMap().values.map { json ->
                    gson.fromJson(json as String, DomainRss::class.java)
                }
            }
    }

    suspend fun delete(url: String){
        context.dataStore.edit {
            it.remove(stringPreferencesKey(url))
        }
    }

}