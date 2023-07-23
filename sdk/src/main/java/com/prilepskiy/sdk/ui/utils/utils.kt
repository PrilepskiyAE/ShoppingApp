package com.prilepskiy.sdk.ui.utils

fun Int.formatter():String{
    val number=this.toString().reversed()
    val result= buildString {
        for (i in number.indices) {
            if (i % 3 == 0 && i > 0) append(' ')
            append(number[i])
        }
    }
  return  result.reversed()
    }


