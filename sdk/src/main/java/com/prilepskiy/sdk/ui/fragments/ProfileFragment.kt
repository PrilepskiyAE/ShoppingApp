package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.sdk.databinding.FragmentProfileBinding
import com.prilepskiy.core.presenter.viewmodel.ProfileFragmentViewModel
import com.prilepskiy.sdk.ui.adapter.ExpListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    val viewModel: ProfileFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTest()
        viewModel.getTest1()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.groupQuestionHistory.collectLatest {
                val adapter = it?.let { list ->
                    context?.let { context -> ExpListAdapter(context, list) }
                }
                binding.expendableListHistory.setAdapter(adapter)
            }

        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.groupQuestionFavorite.collectLatest {
                val adapter = it?.let { list ->
                    context?.let { context -> ExpListAdapter(context, list) }
                }
                binding.expendableListFavorite.setAdapter(adapter)
            }

        }
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }
}