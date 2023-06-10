package com.prilepskiy.sdk.ui.fragments


import com.prilepskiy.sdk.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {


    companion object {


        @JvmStatic
        fun newInstance() =
            SearchFragment()

    }
}