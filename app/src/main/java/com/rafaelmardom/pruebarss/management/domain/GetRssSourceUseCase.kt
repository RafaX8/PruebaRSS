package com.rafaelmardom.pruebarss.management.domain

class GetRssSourceUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    fun execute (): List<DomainRss> {
        return domainRssRepository.getAll()
    }
}