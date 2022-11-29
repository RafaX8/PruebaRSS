package com.rafaelmardom.pruebarss.management.data

import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRssRepository

class RssDataRepository (private val source: RssXmlLocalDataSource): DomainRssRepository{
    override fun save(website: String, url: String) {
        source.save(website, url)
    }
}