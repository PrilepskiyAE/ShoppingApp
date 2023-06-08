package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.prilepskiy.sdk.databinding.FragmentDishesBinding





class DishesFragment : BaseFragment<FragmentDishesBinding>(FragmentDishesBinding::inflate) {

    private var categoryName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            categoryName = it.getString(ARG_PARAM1)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryName?.let { binding.toolbarNavigation.setTitleText(it) }
        binding.toolbarNavigation.onClick {
            Log.d(TAG, "onViewCreated: ")
            popBackStack()
        }
    }

    companion object {
       const val TAG = "DishesFragment"
        const val ARG_PARAM1 = "category Name"
        @JvmStatic
        fun newInstance(categoryName: String) =
            DishesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, categoryName)
                }
            }
    }
}