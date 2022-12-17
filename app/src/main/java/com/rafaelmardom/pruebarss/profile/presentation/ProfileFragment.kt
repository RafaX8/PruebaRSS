package com.rafaelmardom.pruebarss.profile.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafaelmardom.pruebarss.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    var binding: FragmentProfileBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding?.root
    }
}