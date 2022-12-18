package com.rafaelmardom.pruebarss.management.presentation

import android.content.Context
import android.content.SharedPreferences
import com.rafaelmardom.pruebarss.management.data.RssDataRepository
import com.rafaelmardom.pruebarss.management.data.local.xml.RssXmlLocalDataSource
import com.rafaelmardom.pruebarss.management.domain.DeleteRssUseCase
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase
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
    // MANAGEMENT
    fun getRssManagementViewModel(applicationContext: Context) : RssManagementViewModel{
        return RssManagementViewModel(
            getRssSourceUseCase(applicationContext),
            deleteRssSourceUseCase(applicationContext)
        )
    }
    private fun getRssSourceUseCase(context: Context): GetRssSourceUseCase {
        return GetRssSourceUseCase(
            getRssRepository(context)
        )
    }

    private fun deleteRssSourceUseCase(context: Context): DeleteRssUseCase {
        return DeleteRssUseCase(
            getRssRepository(context)
        )
    }

    //
    private fun getRssRepository(context: Context): RssDataRepository {
        return RssDataRepository(
            RssXmlLocalDataSource(
                context.getSharedPreferences("rssLocal", Context.MODE_PRIVATE)
            )
        )
    }
}