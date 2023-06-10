package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentProfileBinding
import com.prilepskiy.sdk.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {


    companion object {


        @JvmStatic
        fun newInstance() =
            SearchFragment()

    }
}