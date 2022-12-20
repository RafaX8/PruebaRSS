package com.rafaelmardom.pruebarss.management.data

import com.rafaelmardom.pruebarss.management.data.local.datastore.RssDataStore
import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.DomainRssRepository
import kotlinx.coroutines.flow.Flow

class RssDataRepository (
//    private val localSource: RssXmlLocalDataSource
    private val localSource: RssDataStore
): DomainRssRepository{
    override suspend fun save(website: String, url: String) {
        localSource.save(website, url)
    }

    override suspend fun getAll(): Flow<List<DomainRss>> {
        return localSource.getAll()
    }

    override suspend fun delete(url: String){
        localSource.delete(url)
    }
    /*
    override fun save(website: String, url: String) {
        localSource.save(website, url)
    }

    override fun getAll(): List<DomainRss> {
        return localSource.getAll()
    }

    override fun delete(url: String): Boolean = localSource.delete(url)
     */

}