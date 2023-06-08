package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_LABELED
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import com.prilepskiy.sdk.databinding.FragmentMainBinding


class MainFragment  : Fragment() {
    private lateinit var navController: NavController
    private lateinit var navHost: NavHostFragment
    lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navHost =
            childFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHost.navController
        onBottomNavClicks()
    }

    private fun onBottomNavClicks(){
        binding.bottomNav.labelVisibilityMode=LABEL_VISIBILITY_LABELED
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){

                R.id.homeFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                   // openFragment( HomeFragment.newInstance())
                    navController.popBackStack(R.id.homeFragment, false, saveState = true)
                }

                R.id.searchFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    //openFragment( SearchFragment.newInstance())
                    navController.navigate(R.id.searchFragment, null)
                    }
                R.id.shoppingBasketFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                   // openFragment(ShoppingBasketFragment.newInstance())
                    navController.navigate(R.id.shoppingBasketFragment, null)
                }
                R.id.profileFragment->{
                    Log.d(TAG, "onBottomNavClicks:${it.itemId} ")
                    navController.navigate(R.id.profileFragment, null)
                   // openFragment(ProfileFragment.newInstance())
                }
            }
            true
        }
    }


    companion object{
        const val TAG="MainFragment"
    }
}