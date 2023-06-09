package com.prilepskiy.sdk.ui.utils

import java.text.SimpleDateFormat
import java.util.Calendar

object TimerUtils {


    private var dateFormatter= SimpleDateFormat("dd MMMM, yyyy")

    fun getDate():String{
        val cv= Calendar.getInstance()

        return dateFormatter.format(cv.time)
    }

}