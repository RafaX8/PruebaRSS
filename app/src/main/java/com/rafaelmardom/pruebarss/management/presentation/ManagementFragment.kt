package com.rafaelmardom.pruebarss.management.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafaelmardom.pruebarss.databinding.FragmentManagementBinding

class ManagementFragment : Fragment() {

    var binding: FragmentManagementBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementBinding.inflate(inflater)
        return binding?.root
    }
}