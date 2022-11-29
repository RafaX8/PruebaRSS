package com.rafaelmardom.pruebarss.management.data.local

import com.rafaelmardom.app.data.either.Either
import com.rafaelmardom.app.data.either.ErrorApp

interface RssLocalDataSource {
    fun getAll(): Either<List<RssLocalDataModel>, ErrorApp>
    fun getByWebsite(rssWebsite: String): Either<RssLocalDataModel, ErrorApp>
    fun save(website: String, url: String)
    fun saveAll(rssList: List<RssLocalDataModel>)
}