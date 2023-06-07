package com.prilepskiy.data.utils
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    lateinit var request: Request
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val requestBuilder = originalRequest.newBuilder()
            .method(originalRequest.method, originalRequest.body)
        request = requestBuilder.build()
        Log.d(TAG, "intercept -> \n method: ${originalRequest.method} | body: ${originalRequest.body} ")
        return chain.proceed(request)
    }
    companion object{
   const val TAG ="HeaderInterceptor"
    }
}