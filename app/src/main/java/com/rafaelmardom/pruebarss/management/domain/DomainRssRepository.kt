package com.rafaelmardom.pruebarss.management.domain

interface DomainRssRepository {
    fun save(page:String, url:String)
}