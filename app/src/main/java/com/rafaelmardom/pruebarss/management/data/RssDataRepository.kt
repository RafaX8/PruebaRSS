package com.rafaelmardom.pruebarss.management.data

import com.rafaelmardom.app.data.either.Either
import com.rafaelmardom.app.data.either.ErrorApp
import com.rafaelmardom.app.data.either.right
import com.rafaelmardom.pruebarss.management.data.local.RssLocalDataModel
import com.rafaelmardom.pruebarss.management.data.local.toDomain
import com.rafaelmardom.pruebarss.management.data.local.toLocal
import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.DomainRssRepository

class RssDataRepository (
    private val localSource: RssXmlLocalDataSource
): DomainRssRepository{

    override fun getAll(): Either<ErrorApp, List<DomainRss>> {
        val list = localSource.getAll().get()
        val map = mutableListOf<DomainRss>()
        list.forEach {
            map.add(it.toDomain())
        }
        return map.right()
    }

    override fun getByWebsite(rssWebsite: String): Either<ErrorApp, DomainRss> {
        return localSource.getByWebsite(rssWebsite).get().toDomain().right()
    }

    override fun save(website: String, url: String) {
        localSource.save(website, url)
    }

    override fun saveAll(rssList: List<DomainRss>) {
        val map = mutableListOf<RssLocalDataModel>()
        rssList.forEach {
            map.add(it.toLocal())
        }
        localSource.saveAll(map)
    }
}