package com.rafaelmardom.pruebarss.management.data.local

import com.rafaelmardom.app.data.either.Either
import com.rafaelmardom.app.data.either.ErrorApp

interface RssLocalDataSource {
    fun getAll(): Either<ErrorApp, List<RssLocalDataModel>>
    fun getByWebsite(rssWebsite: String): Either<ErrorApp, RssLocalDataModel>
    fun save(website: String, url: String)
    fun saveAll(rssList: List<RssLocalDataModel>)
}