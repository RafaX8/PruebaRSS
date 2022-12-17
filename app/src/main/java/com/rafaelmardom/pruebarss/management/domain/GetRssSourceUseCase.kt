package com.rafaelmardom.pruebarss.management.domain

class GetRssSourceUseCase(
    private val domainRssRepository: DomainRssRepository
) {
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
}