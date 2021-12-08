package com.cwd.money.network.bean

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ShareInfo(
    val id:Int?,
    val date:String?,
    val code:String?,
    val open:Float?,
    val high:Float?,
    val low:Float?,
    val close:Float?,
    val preclose:Float?,
    val volume:Long?,
    val amount:Long?,
    val adjustflag:Int?,
    val turn:Float?,
    val tradestatus:Int?,
    val pctChg:Float?,
    val peTTM:Float?,
    val pbMRQ:Float?,
    val psTTM:Float?,
    val pcfNcfTTM:Float?,
    val isST:Int?

):Parcelable