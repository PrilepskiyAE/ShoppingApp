package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.core.presenter.viewmodel.ShoppingBasketFragmentViewModel
import com.prilepskiy.sdk.databinding.FragmentShoppingBasketBinding
import com.prilepskiy.sdk.ui.adapter.BasketAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoppingBasketFragment :
    BaseFragment<FragmentShoppingBasketBinding>(FragmentShoppingBasketBinding::inflate) {
    val viewModel: ShoppingBasketFragmentViewModel by viewModel()
    private val basketAdapter = BasketAdapter({
        viewModel.updateBasketCash(it, true)
    }, {
        viewModel.updateBasketCash(it, false)
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBasket()
        binding.rcBasket.adapter = basketAdapter
        startLocationUpdates {
            viewModel.getGeoCity(it)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.geolocation.collectLatest {
                if (it != null) {
                    binding.toolbarStandard.setTitleText(it)
                }
            }

        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.basketModel.collectLatest {
                basketAdapter.submitList(it)
            }
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ShoppingBasketFragment()
    }
}
