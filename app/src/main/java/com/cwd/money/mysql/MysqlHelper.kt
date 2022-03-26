package com.cwd.money.mysql

import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.dsl.from
import org.ktorm.dsl.select

object MysqlHelper {
    val database by lazy {
        Database.connect(
            url = "jdbc:mysql://47.101.129.61:3306/eyes",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = "de468b87db95db61"
        )
    }

    fun testAA(){
        runBlocking {
            launch {
                withContext(Dispatchers.IO){
                    for (row in database.from(ShareInfo).select()){
                        row[ShareInfo.code]?.log()
                    }
                }
            }
        }
    }


    suspend fun selectAlltable():List<String> {

        val tables = withContext(Dispatchers.IO){
            database.useConnection { conn ->
                val sql = """
        show tables
    """
                conn.prepareStatement(sql).use { statement ->
                    statement.setInt(1, 1)
                    statement.executeQuery().asIterable().map {
                        it.getString(1)
                    }
                }
            }
        }
        return tables
    }

    suspend fun test(){
        withContext(Dispatchers.IO){
            for (row in database.from(ShareInfo).select()){
                println(row[ShareInfo.code])
            }
        }

    }

}

