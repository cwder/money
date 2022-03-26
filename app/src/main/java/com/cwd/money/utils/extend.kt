package com.cwd.money.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

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