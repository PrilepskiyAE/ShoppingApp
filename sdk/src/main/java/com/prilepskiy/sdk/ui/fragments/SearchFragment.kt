package com.prilepskiy.sdk.ui.fragments



import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.core.presenter.viewmodel.SearchFragmentViewModel
import com.prilepskiy.sdk.databinding.FragmentSearchBinding
import com.prilepskiy.sdk.ui.adapter.DisheAdapter
import com.prilepskiy.sdk.ui.dialog.DialogManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    val viewModel: SearchFragmentViewModel by viewModel()
    val disheadapter: DisheAdapter = DisheAdapter{
        DialogManager.showShoppingBasketDialog(requireContext(),{
            viewModel.addBasketCash(it)},it)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {

            binding.rcDishe.adapter=disheadapter
            viewModel.disheModel.collectLatest {

                disheadapter.submitList(it)
            }

        }

        binding.etQuery
            .doOnTextChanged { text, _, _, count ->
                if (count>0){
                viewModel.getDisheQuery(text.toString())
                }else{
                    viewModel.getDisheQuery("")
                }
            }



    }
    companion object {


        @JvmStatic
        fun newInstance() =
            SearchFragment()

    }
}