package com.cwd.money.utils

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

object CoroutineScopes {
    val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO +
            CoroutineExceptionHandler { _, throwable ->
                run {

                }
            })
}