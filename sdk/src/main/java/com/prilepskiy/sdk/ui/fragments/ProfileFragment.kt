package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentProfileBinding
import com.prilepskiy.ui.viewmodel.ProfileFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    val viewModel: ProfileFragmentViewModel by viewModel()




    companion object {

        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }
}