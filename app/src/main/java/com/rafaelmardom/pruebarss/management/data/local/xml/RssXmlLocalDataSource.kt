package com.rafaelmardom.pruebarss.management.data.local.xml

import android.content.SharedPreferences
import com.rafaelmardom.pruebarss.management.data.local.RssLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DomainRss

class RssXmlLocalDataSource (
    private val sharedPreferences: SharedPreferences,
) : RssLocalDataSource {

    private val editor = sharedPreferences.edit()

    override fun save(website: String, url: String) {
        editor.putString(
            url,
            website
        ).apply()
    }

    override fun getAll(): List<DomainRss> =
      sharedPreferences.all.map {
        DomainRss(it.value.toString(), it.key.toString())
    }
}