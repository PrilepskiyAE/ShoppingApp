package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.prilepskiy.presenter.viewmodel.DishesFragmentViewModel
import com.prilepskiy.presenter.viewmodel.HomeFragmentViewModel
import com.prilepskiy.sdk.databinding.FragmentDishesBinding
import com.prilepskiy.sdk.ui.adapter.CategoryAdapter
import com.prilepskiy.sdk.ui.adapter.DisheAdapter
import com.prilepskiy.sdk.ui.adapter.TagAdapter
import com.prilepskiy.sdk.ui.dialog.DialogManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class DishesFragment : BaseFragment<FragmentDishesBinding>(FragmentDishesBinding::inflate) {
    val viewModel: DishesFragmentViewModel by viewModel()
    private var categoryName: String? = null

    val disheadapter: DisheAdapter =DisheAdapter{
        Log.d(TAG, "ttt: $it")
        DialogManager.showShoppingBasketDialog(requireContext(),{},it)
       // DialogManager.showLocEnabledDialog(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            categoryName = it.getString(ARG_PARAM1)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryName?.let { binding.toolbarNavigation.setTitleText(it) }
        viewModel.getTags()
        viewModel.getDisheByTag()
        binding.toolbarNavigation.onClick {
            Log.d(TAG, "onViewCreated: ")
            popBackStack()
        }
        val tagAdapter = TagAdapter {
            Log.d(TAG, "${it.name}: ")
            viewModel.getDisheByTag(it)
            viewModel.tagsModel.value?.let { it1 -> viewModel.activ(it.copy(isActive = true), it1) }


        }
        binding.rcDishe.adapter=disheadapter
        binding.rcTags.adapter=tagAdapter
        viewLifecycleOwner.lifecycleScope.launch {
        viewModel.disheModel.collectLatest {
            disheadapter.submitList(it)
        }

        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tagsModel.collectLatest {
                Log.d(TAG, "onViewCreated: ${it?.size}")
                tagAdapter.submitList(it)
            }
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