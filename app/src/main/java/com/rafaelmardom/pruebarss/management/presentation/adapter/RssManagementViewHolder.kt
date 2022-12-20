package com.rafaelmardom.pruebarss.management.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.pruebarss.databinding.ViewItemRssManagementBinding
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase

class RssManagementViewHolder (
    private val view: View
): RecyclerView.ViewHolder( view ){
    fun bind (
        rss: DomainRss,
//        rss: GetRssSourceUseCase.RssManagement,
        itemClick: ((String) -> Unit?)?
    ){
        val binding = ViewItemRssManagementBinding.bind(view)
        binding.websiteText.text = rss.website
        binding.urlText.text = rss.url
        binding.deleteButton.setOnClickListener {
            itemClick?.invoke(rss.url)
        }
    }
}