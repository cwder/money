package com.cwd.money.core

import com.cwd.money.mysql.DBHelper
import com.cwd.money.utils.log

object Delta :Base() {

    suspend fun bLine(table:String):Boolean{
        val data = DBHelper.singleTable(table)

        data.forEach {
            it.log()
        }

        return false
    }

}