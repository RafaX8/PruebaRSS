package com.rafaelmardom.pruebarss.management.data.local.xml

import android.content.SharedPreferences
import com.rafaelmardom.pruebarss.management.data.local.RssLocalDataSource

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
}