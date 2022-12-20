package com.rafaelmardom.pruebarss.management.domain

import kotlinx.coroutines.flow.Flow

interface DomainRssRepository {
    suspend fun save(website:String, url:String)
    suspend fun getAll(): Flow<List<DomainRss>>
    suspend fun delete(url:String)
    /*
    fun save(website:String, url:String)
    fun getAll(): List<DomainRss>
    fun delete(url:String): Boolean
     */
}