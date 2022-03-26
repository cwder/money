package com.cwd.money.core

import com.cwd.money.mysql.DBHelper

open class Base {
    suspend fun tables():List<String>{
        val tables = DBHelper.allTable()
        return tables
    }
}