package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_LABELED
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import com.prilepskiy.sdk.databinding.FragmentMainBinding


class MainFragment  : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBottomNavClicks()
        openFragment(HomeFragment.newInstance())
    }

    private fun onBottomNavClicks(){
        binding.bNav.labelVisibilityMode=LABEL_VISIBILITY_LABELED
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){

                R.id.homeFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    openFragment( HomeFragment.newInstance())}
                R.id.searchFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    openFragment( SearchFragment.newInstance())}
                R.id.shoppingBasketFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    openFragment(ShoppingBasketFragment.newInstance())}
                R.id.profileFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    openFragment(ProfileFragment.newInstance())}
            }
            true
        }
    }


    companion object{
        const val TAG="MainFragment"
    }
}