package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.prilepskiy.profile.ProfileFragment
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentMainBinding
import com.prilepskiy.sdk.ui.fragments.homeFragment.HomeFragment
import com.prilepskiy.search.ui.SearchFragment
import com.prilepskiy.shopping_basket.ui.ShoppingBasketFragment

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBottomNavClicks()
        openFragment(HomeFragment.newInstance())
    }

    private fun onBottomNavClicks(){
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
    private fun Fragment.openFragment(f:Fragment){
        (activity as AppCompatActivity).supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            .replace(R.id.placeHolder, f)
            .commit()
    }

    companion object{
        const val TAG="MainFragment"
    }
}