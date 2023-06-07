package com.prilepskiy.sdk.ui.fragments

import com.prilepskiy.sdk.databinding.FragmentProfileBinding
import com.prilepskiy.presenter.viewmodel.ProfileFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    val viewModel: ProfileFragmentViewModel by viewModel()




    companion object {

        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }
}