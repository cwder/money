package com.cwd.money.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.cwd.money.mysql.table.ShareInfo
import java.sql.ResultSet

/**
 * 泛型包成reified实体，可当成参数来用
 */
inline fun <reified T:Activity> Context.startActivity(ctx:Context){
    ctx.startActivity(Intent(ctx,T::class.java))
}

inline fun <reified T:Activity> Context.startActivity(ctx:Context,block: Intent.()->Unit){
    val intent = Intent(ctx,T::class.java)
    intent.block()
    ctx.startActivity(intent)
}

fun Any.toast(context: Context,duration:Int = Toast.LENGTH_LONG):Toast{
    return Toast.makeText(context,this.toString(),duration).apply {
        show()
    }
}

fun Any.log(){
    Log.e("aaa",this.toString())
}

fun ResultSet.wrapShare():ShareInfo{
    val id = this.getInt("id")
    val date = this.getString("date")
    val code = this.getString("code")
    val open = this.getFloat("open")
    val high = this.getFloat("high")
    val preclose = this.getFloat("preclose")
    val volume = this.getInt("volume")
    val amount = this.getInt("amount")
    val adjustflag = this.getInt("adjustflag")
    val turn = this.getInt("turn")
    val tradestatus = this.getInt("tradestatus")
    val pctChg = this.getInt("pctChg")
    val peTTM = this.getInt("peTTM")
    val pbMRQ = this.getInt("pbMRQ")
    val psTTM = this.getInt("psTTM")
    val pcfNcfTTM = this.getInt("pcfNcfTTM")
    val isST = this.getInt("isST")

    return ShareInfo(id,
        date,
        code,
        open,
        high,
        preclose,
        volume,
        amount,
        adjustflag,
        turn,
        tradestatus,
        pctChg,
        peTTM,
        pbMRQ,
        psTTM,
        pcfNcfTTM,
        isST
    )
}