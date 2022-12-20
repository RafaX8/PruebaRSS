package com.rafaelmardom.pruebarss.management.domain

class DeleteRssUseCase(
    private val domainRssRepository: DomainRssRepository
) {
    suspend fun execute (url:String){
        domainRssRepository.delete(url)
    }
    //fun execute (url:String): Boolean = domainRssRepository.delete(url)
}