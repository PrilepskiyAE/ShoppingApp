package com.prilepskiy.sdk.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.prilepskiy.sdk.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<S : ViewBinding>(private val inflate: Inflate<S>): Fragment() {
    private lateinit var navController: NavController
    private var _binding:S? = null
    protected val binding get() = _binding!!
    protected fun popBackStack() {
        navController.popBackStack()
    }

    protected fun popBackStack(destinationId: Int) {
        navController.popBackStack(destinationId,false)
    }

    protected fun navigateFragment(destinationId: Int, arg: Bundle? = null) {
        navController.navigate(destinationId, arg)
    }

    protected fun navigateFragment(destinations: NavDirections) {
        navController.navigate(destinations)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        super.onViewCreated(view, savedInstanceState)
    }






//    protected fun Fragment.openFragment(f:Fragment){
//        (activity as AppCompatActivity).
//        supportFragmentManager
//            .beginTransaction()
//            .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
//            .replace(R.id.placeHolder, f)
//            .commit()
//    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}