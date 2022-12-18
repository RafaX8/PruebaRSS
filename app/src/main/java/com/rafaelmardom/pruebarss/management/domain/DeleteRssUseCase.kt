package com.rafaelmardom.pruebarss.management.domain

class DeleteRssUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    fun execute (url:String): Boolean = domainRssRepository.delete(url)
}