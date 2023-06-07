package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prilepskiy.ui.viewmodel.HomeFragmentViewModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    val viewModel: HomeFragmentViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDishe()
    }

    companion object {


        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}