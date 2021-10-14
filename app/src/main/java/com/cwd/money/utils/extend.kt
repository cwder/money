package com.cwd.money.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

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