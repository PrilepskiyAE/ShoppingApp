package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.telephony.PhoneNumberUtils.formatNumber
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.presenter.viewmodel.ShoppingBasketFragmentViewModel
import com.prilepskiy.sdk.databinding.FragmentShoppingBasketBinding
import com.prilepskiy.sdk.ui.adapter.BasketAdapter
import com.prilepskiy.sdk.ui.utils.formatter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoppingBasketFragment :
    BaseFragment<FragmentShoppingBasketBinding>(FragmentShoppingBasketBinding::inflate) {
    val viewModel: ShoppingBasketFragmentViewModel by viewModel()

    private val basketAdapter = BasketAdapter({
        basket, count->
        viewModel.updateBasketCash(basket, true)
        viewModel.getAllSumm()
    }, {
            basket, count->
        viewModel.updateBasketCash(basket, false)
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBasket()
        viewModel.getAllSumm()
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.basketAllSumm.collectLatest {
                if (it!=null){
                val format="Оплатить ${it.formatter()} ₽"
                binding.btAdd.text=format
            } else {
                    val format="Оплатить 0 ₽"
                    binding.btAdd.text=format
            }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ShoppingBasketFragment()
    }
}
