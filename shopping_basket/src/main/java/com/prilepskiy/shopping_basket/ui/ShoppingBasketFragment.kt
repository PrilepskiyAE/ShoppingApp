package com.prilepskiy.shopping_basket.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prilepskiy.shopping_basket.R


class ShoppingBasketFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_shopping_basket, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = ShoppingBasketFragment()
    }
}
