package com.rafaelmardom.pruebarss.management.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.rafaelmardom.pruebarss.R
import com.rafaelmardom.pruebarss.databinding.FragmentManagementBinding
import com.rafaelmardom.pruebarss.management.presentation.adapter.RssAdapter

class ManagementFragment : Fragment() {

    var binding: FragmentManagementBinding?=null
    private val rssAdapter = RssAdapter()
    private val viewModel by lazy {
        ManagementFactory().getRssManagementViewModel(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadRss()
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
        binding?.listRssManagement?.apply {
            adapter = rssAdapter
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            rssAdapter.setOnClick {
                viewModel?.deleteRss(it)
                showSnackbar()
            }
        }
    }

    private fun setupObservers(){
        val rssState = Observer<RssManagementViewModel.ManagementUiState> {
            rssAdapter.setDataItems(it.rssManagement)
        }
        viewModel.managementPublisher.observe(viewLifecycleOwner, rssState)
    }

    fun navigateToBottomSheet(){
        findNavController().navigate(
            ManagementFragmentDirections.toBottomsheet()
        )
    }

    fun showSnackbar() {
        Snackbar.make(
            requireActivity().findViewById(R.id.main_fragment_container),
            "Fuente eliminada correctamente",
            BaseTransientBottomBar.LENGTH_SHORT
        ).show()
    }
}