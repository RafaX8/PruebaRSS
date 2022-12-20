package com.rafaelmardom.pruebarss.management.presentation

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.rafaelmardom.pruebarss.R
import com.rafaelmardom.pruebarss.databinding.AddRssBottomsheetBinding

class AddRssBottomSheetFragment : BottomSheetDialogFragment() {
    var binding: AddRssBottomsheetBinding? = null

    val viewModel by lazy {
        this.activity?.let {
            ManagementFactory().saveRss(
                // it.getSharedPreferences("rssLocal", MODE_PRIVATE),
                this.requireContext()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddRssBottomsheetBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    fun setupView(){
        binding?.apply {
            saveRssButton?.setOnClickListener {
                viewModel?.saveRss(
                    rssInputWebsite.text.toString() ,
                    rssInputUrl.text.toString()
                )
                findNavController().navigateUp()
                showSnackbar()
            }
            binding?.cancelRssButton?.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    fun showSnackbar() {
        Snackbar.make(
            requireActivity().findViewById(R.id.main_fragment_container),
            "Done",
            BaseTransientBottomBar.LENGTH_SHORT
        ).show()
    }
}