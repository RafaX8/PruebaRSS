package com.rafaelmardom.pruebarss.management.data.remote.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET
    fun getRss(@Url url: String): Call<RssApiModel>
}