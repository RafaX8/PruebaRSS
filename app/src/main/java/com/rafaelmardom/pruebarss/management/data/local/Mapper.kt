package com.rafaelmardom.pruebarss.management.data.local

import com.rafaelmardom.pruebarss.management.domain.DomainRss

fun RssLocalDataModel.toDomain () : DomainRss = DomainRss(
    this.website, this.url
)

fun DomainRss.toLocal () : RssLocalDataModel = RssLocalDataModel(
    this.website, this.url
)
