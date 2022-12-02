package com.rafaelmardom.pruebarss.management.domain

interface DomainRssRepository {
    fun save(website: String, url: String)
    fun saveAll(rssList: List<DomainRss>)
}