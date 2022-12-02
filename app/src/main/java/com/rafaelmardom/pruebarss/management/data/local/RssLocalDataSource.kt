package com.rafaelmardom.pruebarss.management.data.local

interface RssLocalDataSource {
    fun save(website: String, url: String)
}