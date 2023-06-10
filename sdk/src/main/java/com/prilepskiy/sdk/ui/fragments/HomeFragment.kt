package com.prilepskiy.sdk.ui.fragments


import android.os.Bundle

import android.view.View

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.core.presenter.viewmodel.HomeFragmentViewModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import com.prilepskiy.sdk.ui.adapter.CategoryAdapter
import com.prilepskiy.sdk.ui.fragments.DishesFragment.Companion.ARG_PARAM1
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    val viewModel: HomeFragmentViewModel by viewModel()
    val adapter:CategoryAdapter=CategoryAdapter{



        navigateFragment(R.id.dishesFragment,Bundle().apply {
            putString(ARG_PARAM1, it.name)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startLocationUpdates {
            viewModel.getGeoCity(it)

        }


        viewModel.getCategory()
        initAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.geolocation.collectLatest {

                if (it != null) {
                    binding.toolbarStandard.setTitleText(it)
                }
            }

        }
    }


    private fun initAdapter() = with(binding) {

        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        rcView.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.categoryModel.collectLatest {

                adapter.submitList(it)
            }
        }
    }

    companion object {
        const val TAG="HomeFragment"


    }
}
