package com.rafaelmardom.pruebarss.management.domain

class SaveRssUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    fun execute (website:String, url:String) {
        domainRssRepository.save(website, url)
    }
}