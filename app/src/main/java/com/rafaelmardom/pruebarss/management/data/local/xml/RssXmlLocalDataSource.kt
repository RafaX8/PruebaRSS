package com.rafaelmardom.pruebarss.management.data.local.xml

import android.content.SharedPreferences
import com.rafaelmardom.app.data.either.Either
import com.rafaelmardom.app.data.either.ErrorApp
import com.rafaelmardom.app.data.either.left
import com.rafaelmardom.app.data.either.right
import com.rafaelmardom.app.serializer.KSerializer
import com.rafaelmardom.pruebarss.management.data.local.RssLocalDataModel
import com.rafaelmardom.pruebarss.management.data.local.RssLocalDataSource

class RssXmlLocalDataSource (
    private val sharedPreferences: SharedPreferences,
    private val serializer: KSerializer
) : RssLocalDataSource {

    private val editor = sharedPreferences.edit()

    override fun getAll(): Either<ErrorApp, List<RssLocalDataModel>> {
        val rssList = mutableListOf<RssLocalDataModel>()

        try {
            sharedPreferences.all.forEach {
                editor.apply {
                    rssList.add(
                        serializer.fromJson(
                            it.value as String,
                            RssLocalDataModel::class.java
                        )
                    )
                }.apply()
            }
            return rssList.right()
        }catch (ex: java.lang.Exception){
            return ErrorApp.DataError().left()
        }
    }

    override fun getByWebsite(rssWebsite: String): Either<ErrorApp, RssLocalDataModel> {
        val jsonRss = sharedPreferences.getString(rssWebsite, null)
        return if (jsonRss == null) {
            ErrorApp.DataError().left()
        } else {
            val rss: RssLocalDataModel = serializer.fromJson(jsonRss, RssLocalDataModel::class.java)
            rss.right()
        }
    }

    override fun save(website: String, url: String) {
        editor.putString(
            website,
            serializer.toJson(
                RssLocalDataModel(website, url),
                RssLocalDataModel::class.java
            )
        ).apply()
    }

    override fun saveAll(rssList: List<RssLocalDataModel>) {
        rssList.forEach {
            save(it.website, it.url)
        }
    }
}