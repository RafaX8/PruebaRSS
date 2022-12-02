package com.rafaelmardom.pruebarss.management.data

import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.DomainRssRepository

class RssDataRepository (
    private val localSource: RssXmlLocalDataSource
): DomainRssRepository{

    override fun save(website: String, url: String) {
        localSource.save(website, url)
    }

    override fun saveAll(rssList: List<DomainRss>) {
        val map = mutableListOf<DomainRss>()
        rssList.forEach {
            map.add(it)
        }
        localSource.saveAll(map)
    }
}