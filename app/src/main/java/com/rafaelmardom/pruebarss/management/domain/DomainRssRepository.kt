package com.rafaelmardom.pruebarss.management.domain

interface DomainRssRepository {
    fun save(website:String, url:String)
    fun getAll(): List<DomainRss>
    fun delete(url:String): Boolean
}