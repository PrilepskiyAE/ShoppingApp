package com.prilepskiy.sdk.ui.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationRequest
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.prilepskiy.domain.model.TagModel
import com.prilepskiy.sdk.databinding.FragmentHomeBinding
import com.prilepskiy.sdk.ui.customviews.ToolbarStandard
import java.util.Locale


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<S : ViewBinding>(private val inflate: Inflate<S>): Fragment() {
    private lateinit var locProvider: FusedLocationProviderClient
    private lateinit var locationRequest: com.google.android.gms.location.LocationRequest
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    var trigerGetgeoLocation:Boolean=true
    private lateinit var activityResultLauncher: ActivityResultLauncher<Array<String>>

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







    private fun initLocation() {
        locationRequest = com.google.android.gms.location.LocationRequest.create()

        locationRequest.interval =INTERVAL_GEO_REQUEST

        locationRequest.fastestInterval =INTERVAL_GEO_REQUEST

         locationRequest.priority = Priority.PRIORITY_HIGH_ACCURACY
        locProvider = LocationServices.getFusedLocationProviderClient(requireContext())
    }
        protected fun startLocationUpdates(site: (tag: String) -> Unit) {

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) { result ->
            var allAreGranted = true
            for(b in result.values) {
                allAreGranted = allAreGranted && b
            }

            if(allAreGranted) {
                Log.d("TagL0", "$allAreGranted: ")
                if (ActivityCompat.checkSelfPermission(

                        requireContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {

                }
                locProvider.requestLocationUpdates(locationRequest, object : LocationCallback() {
                    override fun onLocationResult(p0: LocationResult) {
                        super.onLocationResult(p0)



                        var cityName: String?
                        val geoCoder = Geocoder(requireContext(), Locale.getDefault())
                        geoCoder.getFromLocation(p0.locations.last().latitude,p0.locations.last().longitude,1
                        ) { address ->
                            cityName = address[0]?.adminArea
                            if (cityName == null) {
                                cityName = address[0]?.locality
                                if (cityName == null) {
                                    cityName = address[0]?.subAdminArea
                                }

                            }


                            if (trigerGetgeoLocation){


                                cityName?.let { site(it)
                                    trigerGetgeoLocation=false

                                }
                            }
                        }


                    }
                }, Looper.myLooper())

            }else{
                Manifest.permission.ACCESS_FINE_LOCATION
            }
        }
        val appPerms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        activityResultLauncher.launch(appPerms)

    }
    private fun openSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri
        context.startActivity(intent)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        initLocation()
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    companion object{
        const val INTERVAL_GEO_REQUEST= 600000L
    }

}