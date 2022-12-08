package com.rafaelmardom.pruebarss.management.presentation

import android.content.SharedPreferences
import com.rafaelmardom.pruebarss.management.data.RssDataRepository
import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.SaveRssUseCase

class ManagementFactory {
    fun saveRss(sharedPreferences: SharedPreferences): ManagementViewModel {
        return ManagementViewModel(
            SaveRssUseCase(
                RssDataRepository(
                    RssXmlLocalDataSource(
                        sharedPreferences
                    )
                )
            )
        )
    }
}