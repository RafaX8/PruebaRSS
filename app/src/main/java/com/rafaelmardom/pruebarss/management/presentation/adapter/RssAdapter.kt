package com.rafaelmardom.pruebarss.management.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.pruebarss.R
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase

class RssAdapter : RecyclerView.Adapter<RssManagementViewHolder>()
{
    private val dataItems = mutableListOf<DomainRss>()
    //private val dataItems = mutableListOf<GetRssSourceUseCase.RssManagement>()
    var itemClick: ((String) -> Unit)? = null

    fun setOnClick(itemClick: (String) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(movies: List<DomainRss>/*List<GetRssSourceUseCase.RssManagement>*/) {
        dataItems.clear()
        dataItems.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssManagementViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.view_item_rss_management, // POR CREAR
                parent,
                false
            )

        return RssManagementViewHolder(view)
    }

    override fun onBindViewHolder(holder: RssManagementViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount() = dataItems.size


}