package com.rafaelmardom.pruebarss.management.domain

class SaveRssUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    fun execute (page:String, url:String) {
        domainRssRepository.save(page, url)
    }
}