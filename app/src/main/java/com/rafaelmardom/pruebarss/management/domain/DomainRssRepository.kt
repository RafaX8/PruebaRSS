package com.rafaelmardom.pruebarss.management.domain

import com.rafaelmardom.app.data.either.Either
import com.rafaelmardom.app.data.either.ErrorApp

interface DomainRssRepository {
    fun getAll(): Either<ErrorApp, List<DomainRss>>
    fun getByWebsite(rssWebsite: String): Either<ErrorApp, DomainRss>
    fun save(website: String, url: String)
    fun saveAll(rssList: List<DomainRss>)
}