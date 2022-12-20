package com.rafaelmardom.pruebarss.management.domain

import kotlinx.coroutines.flow.Flow

class GetRssSourceUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    suspend fun execute(): Flow<List<DomainRss>> {
        return domainRssRepository.getAll()
    }
    /*
    fun execute (): List<RssManagement> {
        return domainRssRepository.getAll().map {
            RssManagement(
                it.website,
                it.url
            )
        }
    }

    data class RssManagement(
        val website: String,
        val url: String
    )
     */
}