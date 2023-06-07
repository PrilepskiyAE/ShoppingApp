package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<S : ViewBinding>(private val inflate: Inflate<S>): Fragment() {
    private var _binding:S? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onEach()
        onView()
        onViewClick()
    }
    protected open fun onView() {}

    protected open fun onViewClick() {}

    protected open fun onEach() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}