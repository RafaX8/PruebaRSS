package com.rafaelmardom.pruebarss.management.data.local

import com.rafaelmardom.pruebarss.management.domain.DomainRss

interface RssLocalDataSource {
    fun save(website: String, url: String)
    fun getAll(): List<DomainRss>
    fun delete(url:String) : Boolean
}