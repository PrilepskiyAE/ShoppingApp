package com.prilepskiy.sdk.ui.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object TimerUtils {


    private val dayFormatter= SimpleDateFormat("dd")

    private val monthFormat= SimpleDateFormat("MMMM")

    private val yearFormat=SimpleDateFormat("yyyy")
    fun getDate():String{
        val cv= Calendar.getInstance()

        val day=dayFormatter.format(cv.time)
        val month=monthFormat.format(cv.time).replaceFirstChar(Char::titlecase)
        val year=yearFormat.format(cv.time)
        return "$day $month $year"
    }

}