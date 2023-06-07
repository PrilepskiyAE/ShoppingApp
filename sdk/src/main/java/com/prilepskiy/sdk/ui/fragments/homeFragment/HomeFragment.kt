package com.prilepskiy.sdk.ui.fragments.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prilepskiy.sdk.R
//import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    //val viewModel: HomeFragmentViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {


        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}