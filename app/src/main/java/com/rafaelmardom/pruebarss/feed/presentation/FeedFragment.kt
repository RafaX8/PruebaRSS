package com.rafaelmardom.pruebarss.feed.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafaelmardom.pruebarss.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    var binding:FragmentFeedBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater)
        return binding?.root
    }
}