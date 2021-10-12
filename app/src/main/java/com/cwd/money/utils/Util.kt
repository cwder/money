package com.cwd.money.utils

import android.util.Log
import java.util.*

object Util {
    private val defaultTag = "money"

    fun <T> e(msg:T){
        Log.e(defaultTag,msg.toString())
    }



}