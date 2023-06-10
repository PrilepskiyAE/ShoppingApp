package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.presenter.viewmodel.ShoppingBasketFragmentViewModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentSearchBinding
import com.prilepskiy.sdk.databinding.FragmentShoppingBasketBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoppingBasketFragment  : BaseFragment<FragmentShoppingBasketBinding>(FragmentShoppingBasketBinding::inflate) {
val viewModel:ShoppingBasketFragmentViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startLocationUpdates {
            viewModel.getGeoCity(it)
        }
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.geolocation.collectLatest {
//                Log.d("TAG777", "initAdapter: $it")
//                if (it != null) {
//                    binding.toolbarStandard.setTitleText(it)
//                }
//            }
//
//        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ShoppingBasketFragment()
            }
    }
