package com.cwd.money.mysql

import org.ktorm.database.Database
import org.ktorm.database.asIterable

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
//        runBlocking {
//            launch {
//                withContext(Dispatchers.IO){
//                    for (row in database.from(ShareInfo).select()){
//                        row[ShareInfo.code]?.log()
//                    }
//                }
//            }
//        }
    }

    val names = database.useConnection { conn ->
        val sql = """
        select code from sh000001
    """

        conn.prepareStatement(sql).use { statement ->
            statement.setInt(1, 1)
            statement.executeQuery().asIterable().map { it.getString(1) }
        }


    }


//    suspend fun selectAlltable():List<String> {
//
//        val tables = database.useConnection { conn ->
//            val sql = """select * from sh000001"""
//            conn.prepareStatement(sql).use { statement ->
//                statement.executeQuery().asIterable().map {
//                    //it.log()
//                    //it.getString("code")
//                    ""
//                }
//            }
//        }
//        return tables
//    }

//    suspend fun selectAlltable():List<String>{
//        for (row in database.from(ShareInfo).select()){
//            println(row[ShareInfo.code])
//        }
//        return null;
//    }

}

