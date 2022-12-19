package com.rafaelmardom.pruebarss.management.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class ApiClient (){
    private val apiServices: ApiServices

    init {
        apiServices = retrofitBuild()
    }

    private fun retrofitBuild() = Retrofit.Builder()
        .baseUrl("https://google.com")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(ApiServices::class.java)

    fun getRss(url:String) : RssApiModel? {
        val response = apiServices.getRss(url).execute()

        return response.body()
    }
}