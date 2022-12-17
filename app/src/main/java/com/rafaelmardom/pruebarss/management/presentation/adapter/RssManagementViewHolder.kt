package com.rafaelmardom.pruebarss.management.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.pruebarss.databinding.ViewItemRssManagementBinding
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase

class RssManagementViewHolder (
    private val view: View
): RecyclerView.ViewHolder( view ){
    fun bind (rss: GetRssSourceUseCase.RssManagement){
        val binding = ViewItemRssManagementBinding.bind(view)
        binding.websiteText.text = rss.website
        binding.urlText.text = rss.url
    }
}