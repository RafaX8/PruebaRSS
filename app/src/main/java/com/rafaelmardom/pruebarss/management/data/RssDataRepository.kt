package com.rafaelmardom.pruebarss.management.data

import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRssRepository

class RssDataRepository (
    private val localSource: RssXmlLocalDataSource
): DomainRssRepository{

    override fun save(website: String, url: String) {
        localSource.save(website, url)
    }

}