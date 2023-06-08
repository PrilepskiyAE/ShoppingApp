package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.presenter.viewmodel.HomeFragmentViewModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import com.prilepskiy.sdk.ui.adapter.CategoryAdapter
import com.prilepskiy.sdk.ui.fragments.DishesFragment.Companion.ARG_PARAM1
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    val viewModel: HomeFragmentViewModel by viewModel()
     val adapter:CategoryAdapter=CategoryAdapter{
         Log.d(TAG, "initAdapter: $it")
        //openFragment(DishesFragment.newInstance(it.name))

         navigateFragment(R.id.dishesFragment,Bundle().apply {
             putString(ARG_PARAM1, it.name)
         })
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCategory()
        initAdapter()

    }
    private fun initAdapter() = with(binding) {

        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        rcView.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
        viewModel.categoryModel.collectLatest {
            Log.d(TAG, "initAdapter: $it")
            adapter.submitList(it)
        }
        }

    }

    companion object {
const val TAG="HomeFragment"

        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}