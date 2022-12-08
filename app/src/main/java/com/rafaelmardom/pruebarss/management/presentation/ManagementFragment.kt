package com.rafaelmardom.pruebarss.management.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rafaelmardom.pruebarss.R
import com.rafaelmardom.pruebarss.databinding.FragmentManagementBinding

class ManagementFragment : Fragment() {

    var binding: FragmentManagementBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementBinding.inflate(inflater)
        setupView()
        return binding?.root
    }
    fun setupView(){
        binding?.managementToolbar?.apply {
            title = getString(R.string.sample_management)
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.add_rss -> navigateToBottomSheet()
                }
                true
            }
        }
    }

    fun navigateToBottomSheet(){
        findNavController().navigate(
            ManagementFragmentDirections.toBottomsheet()
        )
    }
}